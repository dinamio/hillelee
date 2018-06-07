package com.kuznetsov.services;


import com.kuznetsov.dao.impl.QuizDaoHibernate;
import com.kuznetsov.entities.QuizDataFromForm;
import com.kuznetsov.entities.QuizzesEntity;
import com.kuznetsov.entities.ThemesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
public class QuizServices {
    private Logger logger = Logger.getLogger(QuizServices.class.getName());

    @Autowired
    private QuizDaoHibernate quizDao;

    private List<QuizzesEntity> subjectQuizList = new ArrayList<>();

    List<QuizDataFromForm> getAllQuizzes() {
        List<QuizzesEntity> quizzesEntities = quizDao.getAllQuizzesFromDB();
        List<QuizDataFromForm> quizDataFromForms = new ArrayList<>();

       quizzesEntities.forEach(quizzesEntity -> {
           QuizDataFromForm quizDataFromForm = new QuizDataFromForm(
            String.valueOf(quizzesEntity.getId()),
            quizDao.getUserFromDB(quizzesEntity.getLogin()).getLogin(),
            quizDao.getSubjectsFromDb(quizzesEntity.getSubject()).getSubject(),
            quizDao.getThemeFromDb(quizzesEntity.getTheme()).getTheme(),
            quizDao.getQuestionsFromDB(quizzesEntity.getTheme()));

           quizDataFromForms.add(quizDataFromForm);

        });
       return quizDataFromForms;
    }

    public void addNewQuiz(String subject, String theme, String login, Map<String, Byte> questionMap) {
    Integer subjectId = quizDao.getSubjectsFromDb(subject).getId();
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

