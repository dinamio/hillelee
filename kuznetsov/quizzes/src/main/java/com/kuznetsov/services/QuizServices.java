package com.kuznetsov.services;

import com.kuznetsov.dao.impl.QuizDaoHibernate;
import com.kuznetsov.dao.impl.daoServices.QuestionsDao;
import com.kuznetsov.dao.impl.daoServices.SubjectsDao;
import com.kuznetsov.dao.impl.daoServices.ThemesDao;
import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.QuizDataFromForm;
import com.kuznetsov.entities.Quizzes;
import com.kuznetsov.entities.Themes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QuizServices {

    @Autowired
    private QuizDaoHibernate quizDao;
    @Autowired
    QuestionsDao questionsDao;
    @Autowired
    SubjectsDao subjectsDao;
    @Autowired
    ThemesDao themesDao;
    @Autowired
    UserDao userDao;

    public List<QuizDataFromForm> getAllQuizzes() {
        List<Quizzes> quizzesEntities = quizDao.getAllQuizzesFromDB();
        List<QuizDataFromForm> quizDataFromForms = new ArrayList<>();

        quizzesEntities.forEach(quizzes -> {
            QuizDataFromForm quizDataFromForm = new QuizDataFromForm(
                    String.valueOf(quizzes.getId()),
                    userDao.getUserFromDB(quizzes.getLogin()).getLogin(),
                    subjectsDao.getSubjectsFromDb(quizzes.getSubject()).getSubject(),
                    themesDao.getThemeFromDb(quizzes.getTheme()).getTheme(),
                    questionsDao.getQuestionsFromDB(quizzes.getTheme()));

            quizDataFromForms.add(quizDataFromForm);

        });
        return quizDataFromForms;
    }

    public void addNewQuiz(String subject, String theme, String login, Map<String, Byte> questionMap) {
        Integer subjectId = subjectsDao.getSubjectsFromDb(subject).getId();
        Integer themeId = themesDao.saveThemeToBd(new Themes(theme));
        Integer loginId = userDao.getUserFromDB(login).getId();
        questionsDao.saveQuestionsToBd(themeId, questionMap);

        quizDao.addNewQuizToDB(new Quizzes(loginId, subjectId, themeId));
    }

    public void removeQuizById(int id) {
        quizDao.removeQuizFromDB(id);
    }
}

