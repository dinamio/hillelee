package dao;

import entity.Question;

import java.util.List;

public interface QuestionDAO {

    public int addQuestion(Question question, int quizId);

    public Question getQuestion(int id);

    public List<Question> getQuestionsForQuiz (int quizId);
}
