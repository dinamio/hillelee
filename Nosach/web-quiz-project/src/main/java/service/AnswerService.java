package service;

import dao.AnswerDAO;

import dao.AnswerDAOImpl;
import entity.Answer;
import entity.Question;

import java.util.List;

public class AnswerService {

    public int addAnswer(Answer answer, int questId) {
        AnswerDAO ad = new AnswerDAOImpl();
        return ad.addAnswer(answer, questId);
    }

    public Answer getAnswer(int id) {
        AnswerDAO ad = new AnswerDAOImpl();
        return ad.getAnswer(id);
    }

    public List<Answer> getAnswersForQuestion(int questionId){
        AnswerDAO ad = new AnswerDAOImpl();
        return ad.getAnswersForQuestion(questionId);
    }

}
