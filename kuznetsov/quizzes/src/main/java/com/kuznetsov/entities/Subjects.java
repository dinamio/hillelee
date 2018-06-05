package com.kuznetsov.entities;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject")
    private Quizzes quizzes;*/

    public Subjects(String subject, Quizzes quizzes) {
        super();
        this.subject = subject;
        this.quizzes = quizzes;
    }

    public Subjects() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }
}
