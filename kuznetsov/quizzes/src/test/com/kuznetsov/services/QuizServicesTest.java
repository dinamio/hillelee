package com.kuznetsov.services;

import com.kuznetsov.dao.impl.daoServices.QuizDao;
import com.kuznetsov.dao.impl.daoServices.SubjectsDao;
import com.kuznetsov.dao.impl.daoServices.ThemesDao;
import com.kuznetsov.dao.impl.daoServices.UserDao;
import com.kuznetsov.entities.Quizzes;
import com.kuznetsov.entities.Subjects;
import com.kuznetsov.entities.Themes;
import com.kuznetsov.entities.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class QuizServicesTest {

    @Mock
    private QuizDao quizDao;
    @Mock
    private QuestionHandler questionHandler;
    @Mock
    private SubjectsDao subjectsDao;
    @Mock
    private ThemesDao themesDao;
    @Mock
    private UserDao userDao;

    @Test
    public void getAllQuizzes() {
        when(subjectsDao.findById(any(Integer.class))).thenReturn(java.util.Optional.of(new Subjects()));
        when(themesDao.findById(any(Integer.class))).thenReturn(java.util.Optional.of(new Themes()));
        when(userDao.findById(any(Integer.class))).thenReturn(java.util.Optional.of(new Users()));
        when(quizDao.findById(any(Integer.class))).thenReturn(java.util.Optional.of(new Quizzes()));
        when(questionHandler.getQuestions(any(Integer.class))).thenReturn(new HashMap<String, Byte>());

    }

    @Test
    public void addNewQuiz() {
        subjectsDao.save(any(Subjects.class));
        themesDao.save(any(Themes.class));
        userDao.save(any(Users.class));
        quizDao.save(any(Quizzes.class));
        questionHandler.saveQuestions(11, new HashMap<>());

    }

    @Test
    public void removeQuizById() {
        quizDao.deleteById(11);
    }
}