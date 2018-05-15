package enteties;

import java.util.List;

public class SubjectQuiz {
    private static int count;
    private String subject;
    private String theme;
    private String login;
    private int id;
    private List<String> questions;

    public SubjectQuiz(String subject, String theme, String login) {
        this.subject = subject;
        this.theme = theme;
        this.login = login;
        id = count += 1;
    }


    public List<String> getQuestions() {
        return questions;
    }

    public void addQuestionToList(String question) {
        this.questions.add(question);
    }

    public void removeQuestionFromList(int index){
        this.questions.remove(index);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
