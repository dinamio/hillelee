package Entities;

public class QuizTopicBean {
    private String quizSubject;
    private String quizTopic;

    public QuizTopicBean(String testSubject, String testTopic) {
        this.quizSubject = testSubject;
        this.quizTopic = testTopic;
    }

    public String getQuizSubject() {
        return quizSubject;
    }

    public void setQuizSubject(String testSubject) {
        this.quizSubject = testSubject;
    }

    public String getQuizTopic() {
        return quizTopic;
    }

    public void setQuizTopic(String testTopic) {
        this.quizTopic = testTopic;
    }
}

