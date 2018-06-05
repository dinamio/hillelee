package com.kuznetsov.entities;

import javax.persistence.*;

@Entity
@Table(name = "themes")
public class Themes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "theme")
    String theme;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "themes")
    private Quizzes quizzes;

    public Themes() {
    }

    public Themes(String theme, Quizzes quizzes) {
        this.theme = theme;
        this.quizzes = quizzes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }
}
