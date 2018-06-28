package com.kuznetsov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    private String pwd;

    private String role;

    public Users() {
    }

    public Users(Integer id, String login, String pwd) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
    }

    public Users(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
        this.role = "USER";
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
