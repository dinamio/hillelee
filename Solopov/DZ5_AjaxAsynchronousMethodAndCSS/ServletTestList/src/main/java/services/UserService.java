package services;

import hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private hibernate.service.ServiceUser userServ;
    private User currentUser;
    private NavigableSet<User> allUsers= new TreeSet<>();


    public boolean addAccount(User user) {
        allUsers = new TreeSet<>(userServ.findAll());
        boolean result= allUsers.add(user);
        if(result) {
            userServ.persist(user);
            currentUser = user;
        }
            return result;
    }

    public boolean authorizate(String login, String pass) {
        allUsers = new TreeSet<>(userServ.findAll());
        currentUser = userServ.findByLogin(login);
        if (currentUser!= null && pass.equals(currentUser.getPassword())) return true;
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        UserService.currentUser = currentUser;
    }
}
