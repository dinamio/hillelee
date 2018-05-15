package services;


import enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class QuizServices {
    Logger logger = Logger.getLogger(QuizServices.class.getName());

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

    public void addNewQuiz(String subject, String theme, String login) {
        SubjectQuiz subjectTests = new SubjectQuiz(subject, theme, login);
        subjectQuizList.add(subjectTests);
    }

    public void removeQuizById(int id) {

        List<SubjectQuiz> list = new ArrayList<>();
        for (SubjectQuiz test : subjectQuizList) {
            if (!(test.getId() == id)) {
                list.add(test);
                logger.info("add to list " + test.getId());
            }
        }
        subjectQuizList = list;
       logger.info("list size " + subjectQuizList.size());
    }
}

