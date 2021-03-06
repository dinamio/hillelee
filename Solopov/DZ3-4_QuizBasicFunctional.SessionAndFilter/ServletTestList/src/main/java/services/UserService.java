package services;

import entity.User;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserService {
private static Map<String,String> account=new LinkedHashMap<>();//All registered users. key -login, value -password
    private User currentUser;

    public boolean addAcc(String login, String password){
        if (!account.containsKey(login)){
            account.put(login,password);
            User currentUser=new User(login,password);
            return true;
        }
        return false;

    }
    public boolean authorizate(String log,String pass){
        String passValue=account.get(log);
       if(pass.equals(passValue)) return true;
        return false;
    }




    public static Map<String, String> getAcc() {
        return account;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
