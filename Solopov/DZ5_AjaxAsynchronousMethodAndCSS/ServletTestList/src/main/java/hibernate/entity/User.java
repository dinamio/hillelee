package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User implements Comparable<User>{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "regdate")
    java.util.Date dateOfRegistration;

    @Column(name="surname")
    String surname;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    @Column(name="sex")
    boolean sex; //0-Male; 1-Female

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Quiz> quizzes = new ArrayList<>();


    User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Date dateOfRegistration, String surname, String name, String email, boolean sex) {
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDateOfRegistration(Date dateOfReg) { this.dateOfRegistration = dateOfReg; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setSex(boolean sex) { this.sex = sex; }

    public int getId() { return id; }
    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
    public Date getDateOfRegistration() { return dateOfRegistration; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean isSex() { return sex; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return (this.login.compareTo(user.login));
    }
}