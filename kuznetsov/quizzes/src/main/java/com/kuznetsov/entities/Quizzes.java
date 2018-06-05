package com.kuznetsov.entities;

import javax.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quizzes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "questions")
    private Questions questions;

    @OneToOne
    @JoinColumn(name = "subject")
    private Subjects subjects;

    @OneToOne
    @JoinColumn(name = "theme")
    private Themes themes;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name = "login")
    private Users users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Themes getThemes() {
        return themes;
    }

    public void setThemes(Themes themes) {
        this.themes = themes;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
