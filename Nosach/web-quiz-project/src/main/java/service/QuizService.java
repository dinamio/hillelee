package service;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import entity.Quiz;

import java.util.List;

public class QuizService {

    public int addQuiz(Quiz quiz, int subjId){
        QuizDAO qd = new QuizDAOImpl();
        return qd.addQuiz(quiz, subjId);
    }

    public Quiz getQuiz (int id){
        QuizDAO qd = new QuizDAOImpl();
        return qd.getQuiz(id);
    }

    public List<Quiz> getAllQuizzies(){
        QuizDAO qd = new QuizDAOImpl();
        return qd.getAllQuizzies();
    }

    public void deleteQuiz (int id){
        QuizDAO qd = new QuizDAOImpl();
        qd.deleteQuiz(id);
    }

}
