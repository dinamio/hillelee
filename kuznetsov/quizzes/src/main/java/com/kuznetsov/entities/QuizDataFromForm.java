package com.kuznetsov.entities;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuizDataFromForm {
    private String id;
    private String login;
    private String subject;
    private String Theme;
    private Map<String, Byte> questions;

    public QuizDataFromForm() {
    }

    public QuizDataFromForm(String id, String login, String subject, String theme, Map<String, Byte> questions) {
        this.id = id;
        this.login = login;
        this.subject = subject;
        Theme = theme;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Map<String, Byte> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Byte> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuizDataFromForm{" +
                "login='" + login + '\'' +
                ", subject='" + subject + '\'' +
                ", Theme='" + Theme + '\'' +
                ", questions=" + mapToString(questions);
    }

    private String mapToString(Map<String, Byte> map) {
        String result = "";
        for (Map.Entry<String, Byte> entry : map.entrySet()) {
            result += (" | question " + entry.getKey());
            result += (" | answer " + entry.getValue());
        }
        return result;
    }
}
