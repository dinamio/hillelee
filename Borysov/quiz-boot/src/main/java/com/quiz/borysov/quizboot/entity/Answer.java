package com.quiz.borysov.quizboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int id;
    @Column(name = "id_of_question")
    private int idOfQuestion;
    @Column(name = "answer_text")
    private String text;
    @Column(name = "is_right_answer")
    private boolean isRightAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfQuestion() {
        return idOfQuestion;
    }

    public void setIdOfQuestion(int idOfQuestion) {
        this.idOfQuestion = idOfQuestion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    public Answer() {
    }

    public Answer(int id, int idOfQuestion, String text, boolean isRightAnser) {
        this.id = id;
        this.idOfQuestion = idOfQuestion;
        this.text = text;
        this.isRightAnswer = isRightAnser;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", idOfQuestion=" + idOfQuestion +
                ", text='" + text + '\'' +
                ", isRightAnswer=" + isRightAnswer +
                '}';
    }
}
