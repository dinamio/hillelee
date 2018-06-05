package com.kuznetsov.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quizzes", schema = "quiz", catalog = "")
public class QuizzesEntity {
    private int id;
    private Integer login;
    private Integer subject;
    private Integer theme;
    private Integer questions;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false)

    public Integer getLogin() { return login; }

    public void setLogin(Integer login) { this.login = login;
    }

    @Basic
    @Column(name = "subject", nullable = true)
    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "theme", nullable = true)
    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "questions", nullable = true)
    public Integer getQuestions() {
        return questions;
    }

    public void setQuestions(Integer questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizzesEntity that = (QuizzesEntity) o;
        return id == that.id &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subject, theme, questions);
    }
}
