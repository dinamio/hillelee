package borysov.dao;

import borysov.entity.Answer;
import borysov.entity.Quiz;

import java.sql.SQLException;
import java.util.List;

public interface QuizDao {
    List<Quiz> getQuizzesAsAList();

    void addQuizToDB(Quiz quiz) throws SQLException;

    void deleteQuizFromDBById(int id);

    void addQuestionToDB(Integer quizId, String questionText);

    Integer getQuestionIdFromDB(Integer quizId, String questionText);

    void addAnswersToDB(Integer questionId, List<Answer> answersList);
}
