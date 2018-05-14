package services;


import enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.List;

public class QuizServices {

    private static QuizServices instance;
    private List<SubjectQuiz> subjectQuizList = new ArrayList<>();

    private QuizServices() {
    }

    public static QuizServices getInstance() {
        if (instance == null) {
            instance = new QuizServices();
        }
        return instance;
    }

    public List<SubjectQuiz> getSubjectQuizList() {
        return subjectQuizList;
    }

    public void addNewQuiz(String subject, String theme, String login, List<String> questions) {
        SubjectQuiz subjectTests = new SubjectQuiz(subject, theme, login, questions);
        subjectQuizList.add(subjectTests);
    }

    public void removeQuizById(int id) {

        List<SubjectQuiz> list = new ArrayList<>();
        for (SubjectQuiz test : subjectQuizList) {
            if (!(test.getId() == id)) {
                list.add(test);
            }
        }
        subjectQuizList = list;
    }
}

