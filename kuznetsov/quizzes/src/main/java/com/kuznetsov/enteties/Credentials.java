package enteties;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    private Map<String, String> savedCredentials = new HashMap<>();
    private String pwd;
    private String login;


    public Map<String, String> getSavedCredentials() {
        return savedCredentials;
    }

    public void setSavedCredentials(String login, String pwd) {
        savedCredentials.put(login, pwd);
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public boolean checkCredentials(Map<String,String> credentialsFromBD, String sessionLogin, String sessionPwd) {
        for (Map.Entry<String, String> entry : credentialsFromBD.entrySet()){
            if (entry.getKey().equals(sessionLogin) && entry.getValue().equals(sessionPwd)){
                return true;
            }
        }
        return false;
    }
}
