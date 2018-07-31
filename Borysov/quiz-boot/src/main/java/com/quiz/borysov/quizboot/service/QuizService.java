package com.quiz.borysov.quizboot.service;


import com.quiz.borysov.quizboot.config.SecurityConfig;
import com.quiz.borysov.quizboot.dao.QuizDao;
import com.quiz.borysov.quizboot.entity.Answer;
import com.quiz.borysov.quizboot.entity.Quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class QuizService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuizService.class);

   @Autowired
    private QuizDao quizDao;

    public List<Quiz> getListOfQuizzes() {

        return (List<Quiz>) quizDao.findAll();
    }

    public void addQuiz(Quiz quiz){
            quizDao.save(quiz);
    }

    public void removeQuizById(int id) {
        quizDao.deleteById(id);
    }

}
