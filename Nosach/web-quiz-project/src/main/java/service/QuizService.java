package service;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizService {

    @Autowired
    QuizDAO qd;

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
