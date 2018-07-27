package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.QuizDAO;
import com.nosach.quizproject.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    public int addQuiz(Quiz quiz){
         Quiz quizz = quizDAO.save(quiz);
         return quizz.getId();
    }

    public Quiz getQuiz (int id){
         Optional<Quiz> opt = quizDAO.findById(id);
         if(opt.isPresent())
             return opt.get();
         return null;
    }

    public List<Quiz> getAllQuizzies(){
        return (List<Quiz>) quizDAO.findAll();
    }

    public void deleteQuiz (int id){
        quizDAO.deleteById(id);
    }

}
