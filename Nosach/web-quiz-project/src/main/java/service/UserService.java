package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void addUser(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.addUser(user);
    }

    public User getUser(String login) {
        User user = userDAO.getUser(login);
        return user;
    }
}
