package service;

import dao.AnswerDAO;

import dao.AnswerDAOImpl;
import entity.Answer;
import entity.Question;

import java.util.List;

public class AnswerService {

    AnswerDAO ad = new AnswerDAOImpl();

    public int addAnswer(Answer answer, int questId) {
        return ad.addAnswer(answer, questId);
    }

    public Answer getAnswer(int id) {
        return ad.getAnswer(id);
    }

    public List<Answer> getAnswersForQuestion(int questionId){
        return ad.getAnswersForQuestion(questionId);
    }

}
