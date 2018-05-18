package service;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import entity.Quiz;

import java.util.List;

public class QuizService {

    QuizDAO qd = new QuizDAOImpl();

    public int addQuiz(Quiz quiz, int subjId){
         return qd.addQuiz(quiz, subjId);
    }

    public Quiz getQuiz (int id){
        return qd.getQuiz(id);
    }

    public List<Quiz> getAllQuizzies(){
        return qd.getAllQuizzies();
    }

    public void deleteQuiz (int id){
        qd.deleteQuiz(id);
    }

}
