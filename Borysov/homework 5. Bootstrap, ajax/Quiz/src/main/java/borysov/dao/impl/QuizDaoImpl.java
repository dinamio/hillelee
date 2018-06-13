package borysov.dao.impl;

import borysov.dao.ConnectionPool;
import borysov.dao.QuizDao;
import borysov.entity.Answer;
import borysov.entity.Quiz;
import borysov.exception.DAOException;
import borysov.service.UserService;
import borysov.utility.Convertor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
@Repository
public class QuizDaoImpl implements QuizDao {
    private static Connection connection = ConnectionPool.getConnection();
    private static final Logger LOGGER = Logger.getLogger(UserService.class);


    public List<Quiz> getQuizzesAsAList() {
        List<Quiz> listOfQuizzes = new ArrayList<Quiz>();

        String SELECT = "SELECT * FROM quizzes";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Quiz quiz = new Quiz();
                quiz.setId(resultSet.getInt("id"));
                quiz.setNameOfSubject(resultSet.getString("subject"));
                quiz.setTheme(resultSet.getString("theme"));
                quiz.setAuthor(resultSet.getString("author"));
                listOfQuizzes.add(quiz);

            }
        } catch (SQLException e) {
            LOGGER.error("getQuizzesAsAList SQL Exception",e);
            throw new DAOException("DAOException while UserDaoImpl.getUserByLoginAndPass()");
        }
        return listOfQuizzes;
    }

    public void addQuizToDB(Quiz quiz) {
        String INSERT_NEW = "INSERT INTO quizzes (subject, theme, author)  VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, quiz.getNameOfSubject());
            preparedStatement.setString(2, quiz.getTheme());
            preparedStatement.setString(3, quiz.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addQuizToDB SQL Exception",e);
        }

    }

    public void deleteQuizFromDBById(int id) {
        String DELETE = "DELETE FROM quizzes WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("deleteQuizFromDBById SQL Exception",e);
        }
    }

    public void addQuestionToDB(Integer quizId, String questionText) {
        String INSERT_NEW = "INSERT INTO questions (id_of_quiz, text_question)  VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, quizId);
            preparedStatement.setString(2, questionText);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addQuationToDB SQL Exception",e);
        }
    }

    public Integer getQuestionIdFromDB(Integer quizId, String questionText) {
        Integer quationId = null;

        String SELECT = "SELECT id FROM questions WHERE id_of_quiz=? AND text_question=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);

            statement.setInt(1, quizId);
            statement.setString(2, questionText);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                quationId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error("getQuiztionIdFromDB SQL Exception",e);
        }
        return quationId;
    }

    public void addAnswersToDB(Integer questionId, List<Answer> answersList) {
        String INSERT_NEW = "INSERT INTO answers (id_of_question, answer_text, is_right_answer)  VALUES(?,?,?)";

        try {
            int i = 0;
            while (i < answersList.size()) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
                preparedStatement.setInt(1, questionId);
                preparedStatement.setString(2, answersList.get(i).getText());
                preparedStatement.setInt(3, Convertor.convertBooleanToInteger(answersList.get(i).isRightAnswer()));
                preparedStatement.executeUpdate();
                i++;
            }

        } catch (SQLException e) {
            LOGGER.error("addAnswersToDB SQL Exception",e);
        }
    }
}

