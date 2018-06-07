package com.kuznetsov.entities;

import org.springframework.stereotype.Component;

@Component
public class QuizDataFromForm {
    private String subject;
    private String Theme;

    public QuizDataFromForm() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    @Override
    public String toString() {
        return "QuizDataFromForm{" +
                "subject='" + subject + '\'' +
                ", Theme='" + Theme + '\'' +
                '}';
    }
}
