package com.kuznetsov.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String login;
    String pwd;
    String salt;

    @OneToOne(mappedBy = "user")
    private Quizzes quizzes;

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
