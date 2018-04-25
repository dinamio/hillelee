package model;

import java.util.Objects;

public class Quiz {
    private String subject;
    private String topic;

    public Quiz(String subject, String topic) {
        this.subject = subject;
        this.topic = topic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(subject, quiz.subject) &&
                Objects.equals(topic, quiz.topic);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subject, topic);
    }
}
