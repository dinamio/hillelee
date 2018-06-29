package dao;

import Entities.QuizTopic;
import Entities.Registration;

import java.util.List;

public interface QuizDao {
    List<QuizTopic> getAllQuizzes();

    void insertQuiz(QuizTopic quizTopic);

    void insertQuiz(QuizTopic quizTopic, Registration currentUser);

    void deleteById(Integer id);

}
