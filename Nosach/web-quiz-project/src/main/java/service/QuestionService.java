package service;

import dao.QuestionDAO;
import dao.QuestionDAOImpl;
import entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionService {

    @Autowired
    QuestionDAO qd;

    public int addQuestion(Question question, int quizId) {
        return qd.addQuestion(question, quizId);
    }

    public Question getQuestion(int id) {
        return  qd.getQuestion(id);
    }

    public List<Question> getQuestionsForQuiz(int quizId) {
        return qd.getQuestionsForQuiz(quizId);
    }
}
