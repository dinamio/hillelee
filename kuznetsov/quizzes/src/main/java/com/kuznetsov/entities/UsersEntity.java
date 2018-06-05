package com.kuznetsov.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "quiz")
public class UsersEntity {
    private int id;
    private String login;
    private String pwd;
    private String salt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


   /* @Column(name = "login", nullable = true, length = 45)*/
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "pwd", nullable = true, length = 300)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "salt", nullable = true, length = 300)
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
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(salt, that.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, pwd, salt);
    }
}
