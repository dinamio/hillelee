package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "creator")
    private List<QuizTopic> quizTopicList;

    public Registration() { }

    public Registration(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Registration(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

