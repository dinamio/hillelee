package Entities;

public class RegistrationBean {
    private String login;
    private String password;

    public RegistrationBean(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return login + " " + password;
    }

    @Override
    public int hashCode() {
        return 31 * 31 * login.hashCode() + 31 * password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        RegistrationBean that = (RegistrationBean) obj;
        return this.login.equals(that.login) && this.password.equals(that.password);
    }
}

