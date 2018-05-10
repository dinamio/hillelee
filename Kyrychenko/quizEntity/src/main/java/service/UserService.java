package service;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {
    private List<User> userList;
    private static volatile UserService instance;

    private UserService() {
        this.userList = new ArrayList<>();
    }

    public static UserService getInstance() {
        UserService localInstance = instance;
        if (localInstance == null) {
            synchronized (QuizService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserService();
                }
            }
        }
        return localInstance;
    }

    public boolean isUserExist(String login, String password) {
        User temp = new User("null", login, password);
        return userList.stream().anyMatch(user -> user.equals(temp));
    }

    public boolean isLoginExist(String login) {
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
