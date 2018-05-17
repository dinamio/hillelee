package service;

import dao.entities.QuizDao;
import dao.DaoFactory;
import dao.entities.postgreImpl.PostgreSqlDaoFactory;
import model.Quiz;

import java.util.*;

public class QuizService {

    private QuizDao quizDao;

    public QuizService() {
        this.quizDao = DaoFactory.createQuizDao(new PostgreSqlDaoFactory());
    }

    public void add(Quiz quiz){
        quizDao.create(quiz);
    }

    public void remove(String name){
        quizDao.delete(name);
    }

    public Collection<Quiz> getAll(){
        return quizDao.getAll();
    }

    public Object get(String name) {
        return quizDao.get(name);
    }
}
