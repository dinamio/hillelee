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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        QuizTopicBean that = (QuizTopicBean) obj;
        return this.quizSubject.equals(that.quizSubject) && this.quizTopic.equals(that.quizTopic);
    }

    @Override
    public int hashCode() {
        return 31*31*quizSubject.hashCode()+ 31*quizTopic.hashCode();
    }

    @Override
    public String toString() {
        return quizSubject + " " + quizTopic;
    }
}

