package dao;

import entity.QuizTopic;
import entity.Registration;

import java.util.List;

public interface QuizDao {
    List<QuizTopic> getAllQuizzes();

    void insertQuiz(QuizTopic quizTopic, Registration currentUser);

    void deleteById(Integer id);

}
