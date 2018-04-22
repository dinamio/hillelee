package services;


import com.kuznetsov.enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizServices {
    private List<SubjectQuiz> subjectQuizList = new ArrayList<>();

    private String pwd;
    private String login;
    private Map<String, String> savedCredentials = new HashMap<>();

    public Map<String, String> getSavedCredentials() {
        return savedCredentials;
    }

    public void setSavedCredentials(String login, String pwd) {
        savedCredentials.put(login, pwd);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public List<SubjectQuiz> getSubjectQuizList() {
        return subjectQuizList;
    }

    public void addNewQuiz(String subject, String theme, String login) {
        SubjectQuiz subjectTests = new SubjectQuiz(subject, theme, login);
        subjectQuizList.add(subjectTests);
    }

    public void removeQuizById(String id) {

        int index = 0;

        for (SubjectQuiz quiz : subjectQuizList) {
            if (quiz.getId().equals(id)) {
                index = subjectQuizList.indexOf(quiz);
                break;
            }
        }

        subjectQuizList.remove(index);
    }
}

