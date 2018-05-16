package enteties;

import java.util.List;
import java.util.Map;

public class SubjectQuiz {
    private static int count;
    private String subject;
    private String theme;
    private String login;
    private int id;
    private Map<String, String> questionMap;

    public SubjectQuiz(String subject, String theme, String login, Map<String, String> questionMap) {
        this.subject = subject;
        this.theme = theme;
        this.login = login;
        this.questionMap = questionMap;
        id = count += 1;
    }

    public Map<String, String> getQuestionMap() {
        return questionMap;
    }

    public void setQuestionMap(Map<String, String> questionMap) {
        this.questionMap = questionMap;
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
