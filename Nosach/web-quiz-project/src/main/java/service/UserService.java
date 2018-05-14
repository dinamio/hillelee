package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class UserService {

    public void addUser(User user) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.addUser(user);
    }

    public User getUser(String login) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(login);
        return user;
    }
}
