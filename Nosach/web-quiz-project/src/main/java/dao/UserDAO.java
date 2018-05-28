package dao;

import entity.User;

public interface UserDAO {

    public boolean addUser (User user);

    public User getUser (String login);
}
