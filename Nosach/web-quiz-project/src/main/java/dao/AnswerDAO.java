package dao;

import entity.Answer;

import java.util.List;

public interface AnswerDAO {

    public int addAnswer(Answer answer, int questionId);

    public Answer getAnswer(int id);

    public List<Answer> getAnswersForQuestion(int questionId);
}
