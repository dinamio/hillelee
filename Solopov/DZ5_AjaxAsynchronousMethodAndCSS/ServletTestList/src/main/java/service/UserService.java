package service;

import dao.UserDAOReal;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAOReal userDAOReal;
    private  User currentUser;

    public boolean addAccount(User user) {
    boolean result=false;
        if(userDAOReal.findByLogin(user.getLogin())==null) {
            userDAOReal.persist(user);
            currentUser = user;
            result=true;
        }
            return result;
    }

    public boolean authorizate(String login, String pass) {
        currentUser = userDAOReal.findByLogin(login);
        if (currentUser!= null && pass.equals(currentUser.getPassword())) return true;
        return false;
    }
    public boolean authorizate(User user) {
        currentUser = userDAOReal.findByLogin(user.getLogin());
        if (currentUser!= null && user.getPassword().equals(currentUser.getPassword())) return true;
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
