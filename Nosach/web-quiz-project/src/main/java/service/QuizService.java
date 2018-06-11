package service;

import dao.QuizDAO;
import entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class QuizService {

    @Autowired
    @Qualifier("quizHibernateDao")
    QuizDAO quizDAO;

    public int addQuiz(Quiz quiz){
         return quizDAO.addQuiz(quiz);
    }

    public Quiz getQuiz (int id){
        return quizDAO.getQuiz(id);
    }

    public List<Quiz> getAllQuizzies(){
        return quizDAO.getAllQuizzies();
    }

    public void deleteQuiz (int id){
        quizDAO.deleteQuiz(id);
    }

}
