package com.kuznetsov.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer qiuzId;
    String question;
    Integer answer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question")
    private Quizzes quizzes;

    public Questions() {
    }

    public Questions(Integer qiuzId, String question, Integer answer, Quizzes quizzes) {
        this.qiuzId = qiuzId;
        this.question = question;
        this.answer = answer;
        this.quizzes = quizzes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQiuzId() {
        return qiuzId;
    }

    public void setQiuzId(Integer qiuzId) {
        this.qiuzId = qiuzId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Quizzes getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Quizzes quizzes) {
        this.quizzes = quizzes;
    }
}
