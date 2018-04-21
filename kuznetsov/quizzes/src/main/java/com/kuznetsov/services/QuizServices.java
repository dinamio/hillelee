package kuznetsov.quizzes.src.main.java.com.kuznetsov.services;


import kuznetsov.quizzes.src.main.java.com.kuznetsov.enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.List;

public class QuizServices {
    private List<SubjectQuiz> subjectQuizList = new ArrayList<>();

    public List<SubjectQuiz> getSubjectQuizList() {
        return subjectQuizList;
    }

    public void addNewQuiz(String subject, String theme) {
        SubjectQuiz subjectTests = new SubjectQuiz(subject, theme);
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

