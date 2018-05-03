package entity;

public class User {
    private String login,pswword;


    public User(String login, String pswword) {
        this.login = login;
        this.pswword = pswword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPswword() {
        return pswword;
    }

    public void setPswword(String pswword) {
        this.pswword = pswword;
    }
}
