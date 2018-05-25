package service;

import dao.Credentials;


public class RegistrationService {

    private Credentials credentials;

    public RegistrationService() {
        this.credentials = new Credentials();
    }

    public void addNew(String login, String pass){
        credentials.add(login, pass);
    }

}
