package services;


import enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.List;

public class QuizServices {

    private QuizServices(){}

    private static QuizServices instance;

    public static QuizServices getInstance(){
        if (instance == null){
            instance = new QuizServices();
        }
        return instance;
    }

    private List<SubjectQuiz> subjectQuizList = new ArrayList<>();

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

