package com.kuznetsov.entities;

import javax.persistence.*;
import java.util.Objects;
@Table
@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer theme;
    private String question;
    private Byte answer;

    public Questions(Integer theme, String question, Byte answer) {
        this.theme = theme;
        this.question = question;
        this.answer = answer;
    }

    public Questions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Byte getAnswer() {
        return answer;
    }

    public void setAnswer(Byte answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questions that = (Questions) o;
        return id == that.id &&
                Objects.equals(theme, that.theme) &&
                Objects.equals(question, that.question) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, theme, question, answer);
    }
}
