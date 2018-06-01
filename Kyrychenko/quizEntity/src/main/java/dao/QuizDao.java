package dao;

import model.Quiz;

import java.util.List;

public interface QuizDao {
    boolean addQuiz(Quiz quiz);

    List<Quiz> getQuizList();

    boolean update(Quiz quiz);

    boolean deleteQuiz(int id);
}
