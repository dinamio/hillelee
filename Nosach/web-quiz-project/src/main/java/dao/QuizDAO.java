package dao;

import entity.Quiz;

import java.util.List;

public interface QuizDAO {

    public int addQuiz(Quiz quiz, int subjId);

    public Quiz getQuiz (int id);

    public List<Quiz> getAllQuizzies();

    public void deleteQuiz(int id);

}
