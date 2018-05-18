package service;

import dao.Credentials;

import java.util.Objects;

public class LoginService {

    private Credentials credentials;

    public LoginService() {
        this.credentials = new Credentials();
    }

    public boolean isRegistered(String login, String pass){
        String savedPass = credentials.get(login);
        return Objects.nonNull(savedPass) && savedPass.equals(pass);
    }

}
