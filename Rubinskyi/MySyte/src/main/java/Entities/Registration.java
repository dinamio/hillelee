package Entities;

public class Registration {
    private int id;
    private String login;
    private String password;

    public Registration() { }

    public Registration(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Registration(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Registration that = (Registration) obj;
        return this.login.equals(that.login) && this.password.equals(that.password);
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

