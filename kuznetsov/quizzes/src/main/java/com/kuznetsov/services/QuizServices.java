package com.kuznetsov.services;


import com.kuznetsov.dao.impl.QuizDaoHibernate;
import com.kuznetsov.entities.QuizzesEntity;
import com.kuznetsov.entities.ThemesEntity;
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
    private QuizDaoHibernate quizDao;

    private List subjectQuizList = new ArrayList<>();

    List getSubjectQuizList() {
        return quizDao.getAllQuizzesFromDB();
    }

    public void addNewQuiz(String subject, String theme, String login, Map<String, Byte> questionMap) {
    Integer subjectId = quizDao.getSubjectIdFromDb(subject).getId();
    Integer themeId = quizDao.addThemeToBd(new ThemesEntity(theme));
    Integer loginId = quizDao.getUserFromDB(login).getId();
    quizDao.addQuestionsToBd(themeId, questionMap);

    quizDao.addNewQuizToDB(new QuizzesEntity(loginId, subjectId, themeId));

    }

    public void removeQuizById(int id) {
        quizDao.removeQuizFromDB(id);

        logger.info(String.format("list size %d", subjectQuizList.size()));
    }
}

