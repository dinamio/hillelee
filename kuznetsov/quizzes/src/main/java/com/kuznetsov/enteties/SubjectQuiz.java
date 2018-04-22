package com.kuznetsov.enteties;

public class SubjectQuiz {
    private String id;
    private String subject;
    private String theme;
    private String login;

    public SubjectQuiz(String subject, String theme, String login) {
        this.subject = subject;
        this.theme = theme;
        this.login = login;
        id = this.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
