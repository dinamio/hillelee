package services;


import dao.impl.QuizDaoImpl;
import enteties.SubjectQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class QuizServices {
    private Logger logger = Logger.getLogger(QuizServices.class.getName());
    private QuizDaoImpl quizDao = new QuizDaoImpl();

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

    List<SubjectQuiz> getSubjectQuizList() {
        return quizDao.getAllQuizzesFromDB();
    }

    public void addNewQuiz(String subject, String theme, String login, Map<String, String> questionMap) {
        SubjectQuiz subjectQuiz = new SubjectQuiz(subject, theme, login, questionMap);
        quizDao.addNewQuizToDB(subjectQuiz);
    }

    public void removeQuizById(int id) {
        quizDao.removeQuizFromDB(id);

        logger.info(String.format("list size %d", subjectQuizList.size()));
    }
}

