package Entities;

public class QuizTopic {
    private int id;
    private String quizSubject;
    private String quizTopic;
    private int idCreator;
    private Registration creator;

    public QuizTopic(String testSubject, String testTopic) {
        this.quizSubject = testSubject;
        this.quizTopic = testTopic;
    }

    public QuizTopic() {

    }

    public QuizTopic(int id, String quizSubject, String quizTopic, int idCreator) {
        this.id = id;
        this.quizSubject = quizSubject;
        this.quizTopic = quizTopic;
        this.idCreator = idCreator;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        QuizTopic that = (QuizTopic) obj;
        return this.quizSubject.equals(that.quizSubject) && this.quizTopic.equals(that.quizTopic);
    }

    @Override
    public int hashCode() {
        return 31 * 31 * quizSubject.hashCode() + 31 * quizTopic.hashCode();
    }

    @Override
    public String toString() {
        return quizSubject + " " + quizTopic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public QuizTopic(int id, String quizSubject, String quizTopic, Registration creator) {
        this.id = id;
        this.quizSubject = quizSubject;
        this.quizTopic = quizTopic;
        this.creator = creator;
    }

    public Registration getCreator() {
        return creator;
    }

    public void setCreator(Registration creator) {
        this.creator = creator;
    }
}

