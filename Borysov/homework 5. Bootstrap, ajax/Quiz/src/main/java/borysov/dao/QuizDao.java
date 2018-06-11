package borysov.dao;

import borysov.entity.Answer;
import borysov.entity.Quiz;

import java.sql.SQLException;
import java.util.List;

public interface QuizDao {
    List<Quiz> getQuizzesAsAList();

    void addQuizToDB(Quiz quiz) throws SQLException;

    void deleteQuizFromDBById(int id);

    void addQuestionToDB(Integer quizId, String quationText);

    Integer getQuiztionIdFromDB(Integer quizId, String quationText);

    void addAnswersToDB(Integer quationId, List<Answer> answersList);
}
