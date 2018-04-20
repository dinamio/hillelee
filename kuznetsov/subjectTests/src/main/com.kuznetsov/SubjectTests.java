package com.kuznetsov;

public class SubjectTests {
    private String id;
    private String subject;
    private String theme;

    SubjectTests(String subject, String theme) {
        this.subject = subject;
        this.theme = theme;
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
