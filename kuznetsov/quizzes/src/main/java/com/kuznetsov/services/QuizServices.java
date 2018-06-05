package com.kuznetsov.services;


import com.kuznetsov.dao.impl.QuizDaoImpl;
import com.kuznetsov.entities.SubjectQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class QuizServices {
    private Logger logger = Logger.getLogger(QuizServices.class.getName());

    @Autowired
    private QuizDaoImpl quizDao;

    private List<SubjectQuiz> subjectQuizList = new ArrayList<>();

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

