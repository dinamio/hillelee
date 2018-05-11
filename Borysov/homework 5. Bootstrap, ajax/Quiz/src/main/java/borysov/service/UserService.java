package borysov.service;

import borysov.entity.*;
import borysov.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static List<User> users = new ArrayList<User>();


    static {

        User user1 = new User("11", "11", "mail");
        User user2 = new User("alex", "alex1", "email");
        users.add(user1);
        users.add(user2);

    }

    public User getUserByLoginAndPass(String login, String password) throws DAOException {
        for (User user : users) {
            System.out.println(user);
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new DAOException("There isn't that user");
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }
}
