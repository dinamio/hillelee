package service;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {
    private List<User> userList;

    private UserService() {
        this.userList = new ArrayList<>();
    }

    private static class UserServiceHolder {
        private static final UserService instance = new UserService();
    }

    public static UserService getInstance() {
        return UserServiceHolder.instance;
    }

    public boolean isUserAccountFound(String login, String password) {
        return userList.stream().anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
    }

    public boolean validateUserExists(String login) {
        return userList.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    public boolean addUser(User user) {
        Objects.requireNonNull(user);
        return userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
