package com.kuznetsov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "quiz")
@Component
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    private String pwd;

    private String salt;

    public Users() {
    }

    public Users(Integer id, String login, String pwd, String salt) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.salt = salt;
    }

    public Users(String login, String pwd, String salt) {
        this.login = login;
        this.pwd = pwd;
        this.salt = salt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, pwd, salt);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
