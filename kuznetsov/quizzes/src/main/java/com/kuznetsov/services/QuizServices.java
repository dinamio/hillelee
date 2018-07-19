package com.kuznetsov.services;

import com.kuznetsov.dao.impl.daoServices.QuizDao;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuizServices {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    QuestionHandler questionHandler;
    @Autowired
    SubjectsDao subjectsDao;
    @Autowired
    ThemesDao themesDao;
    @Autowired
    UserDao userDao;

    public List<QuizDataFromForm> getAllQuizzes() {
        List<Quizzes> quizzesEntities = (List<Quizzes>) quizDao.findAll();
        List<QuizDataFromForm> quizDataFromForms = new ArrayList<>();

        quizzesEntities.forEach(quizzes -> {
            QuizDataFromForm quizDataFromForm = new QuizDataFromForm(
                    String.valueOf(quizzes.getId()),
                    userDao.getUsersById(quizzes.getLogin()).getLogin(),
                    subjectsDao.getSubjectsById(quizzes.getSubject()).getSubject(),
                    themesDao.getThemesById(quizzes.getTheme()).getTheme(),
                    questionHandler.getQuestions(quizzes.getTheme()));

            quizDataFromForms.add(quizDataFromForm);

        });
        return quizDataFromForms;
    }

    public void addNewQuiz(String subject, String theme, String login, Map<String, Byte> questionMap) {
        Integer subjectId = subjectsDao.getSubjectsBySubject(subject).getId();
        Integer themeId = themesDao.save(new Themes(theme)).getId();
        Integer loginId = userDao.getUsersByLogin(login).getId();
        questionHandler.saveQuestions(themeId, questionMap);

        quizDao.save(new Quizzes(loginId, subjectId, themeId));
    }

    public void removeQuizById(int id) {
        /*quizDao.removeQuizzes(id);*/
    }
}

