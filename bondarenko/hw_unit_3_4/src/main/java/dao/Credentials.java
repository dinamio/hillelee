package dao;

import java.util.HashMap;
import java.util.Map;

public class Credentials {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("root", "root");
    }

    public void add(String login, String pass){
        credentials.put(login, pass);
    }

    public void delete(String login){
        credentials.remove(login);
    }

    public String get(String login){
        return credentials.get(login);
    }

}
