package service;

import dao.UserDao;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean isUserAccountDataMatch(String login, String password) {
        return checkPass(password, userDao.getUserPass(login));
    }

    public boolean validateUserExists(String login) {
        return userDao.validateUserExists(login);
    }

    public boolean addUser(User user) {
        Objects.requireNonNull(user);
        user.setPassword(hashPassword(user.getPassword()));
        return userDao.addUser(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPass(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
