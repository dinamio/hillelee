package service;

import dao.QuestionDAO;
import dao.QuestionDAOImpl;
import entity.Question;

import java.util.List;

public class QuestionService {

    QuestionDAO qd = new QuestionDAOImpl();

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
