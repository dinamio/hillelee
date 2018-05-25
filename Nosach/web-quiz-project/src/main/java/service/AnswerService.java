package service;

import dao.AnswerDAO;

import dao.AnswerDAOImpl;
import entity.Answer;
import entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerService {

    @Autowired
    AnswerDAO ad;

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
