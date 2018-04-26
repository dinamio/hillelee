package enteties;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    private static Credentials entity;
    private Map<String, String> savedCredentials = new HashMap<>();
    private String pwd;
    private String login;

    private Credentials() {
    }

    public static Credentials getSingleton() {
        if (entity == null) {
            entity = new Credentials();
        }
        return entity;
    }


    public Map<String, String> getSavedCredentials() {
        return savedCredentials;
    }

    public void setSavedCredentials(String login, String pwd) {
        savedCredentials.put(login, pwd);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
