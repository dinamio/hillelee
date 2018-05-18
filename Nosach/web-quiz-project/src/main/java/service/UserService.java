package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    UserDAO userDAO = new UserDAOImpl();

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
