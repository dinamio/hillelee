package com.kuznetsov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quizzes", schema = "quiz")
@Component
public class QuizzesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer login;
    private Integer subject;
    private Integer theme;

    public QuizzesEntity(Integer login, Integer subject, Integer theme) {

        this.login = login;
        this.subject = subject;
        this.theme = theme;
    }

    public QuizzesEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizzesEntity that = (QuizzesEntity) o;
        return id == that.id &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(theme, that.theme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subject, theme);
    }
}
