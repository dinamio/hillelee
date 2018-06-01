package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class UserService {
    private UserDao userDao;

    private UserService() {
        userDao = new UserDaoImpl();
    }

    private static class UserServiceHolder {
        private static final UserService instance = new UserService();
    }

    public static UserService getInstance() {
        return UserServiceHolder.instance;
    }

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

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPass(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
