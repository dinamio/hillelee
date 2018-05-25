package dao;

import entity.User;

public interface UserDAO {

    public void addUser (User user);

    public User getUser (String login);
}
