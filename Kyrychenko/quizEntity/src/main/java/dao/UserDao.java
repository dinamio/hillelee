package dao;

import model.User;

public interface UserDao {
    boolean addUser(User user);

    String getUserPass(String login);

    boolean validateUserExists(String login);

    boolean update(User user);
}
