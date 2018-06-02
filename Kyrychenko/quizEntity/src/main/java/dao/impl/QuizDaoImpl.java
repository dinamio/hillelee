package dao.impl;

import dao.QuizDao;
import dao.connector.ConnectionHandler;
import model.Quiz;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDaoImpl implements QuizDao {
    private Connection connection;
    private Logger logger;

    private static final String GET_USER_ID = "SELECT id FROM user WHERE login=?";
    private static final String ADD_NEW_QUIZ = "INSERT into quiz (subject, topic, quiz_author_id) VALUE (?,?,?)";
    private static final String GET_ALL_QUIZZES = "SELECT * FROM quiz INNER JOIN user ON quiz.quiz_author_id = user.id";
    private static final String UPDATE_QUIZ = "UPDATE quiz SET subject=?, topic=? WHERE quiz.id=?";
    private static final String DELETE_QUIZ = "DELETE FROM quiz WHERE quiz.id=?";


    public QuizDaoImpl() {
        this.logger = Logger.getLogger(this.getClass());
        try {
            this.connection = ConnectionHandler.getConnection();
        } catch (SQLException e) {
            logger.error("Connection fail " + e.getLocalizedMessage(), e.fillInStackTrace());
        } catch (ClassNotFoundException e) {
            logger.error("Driver not found " + e.getLocalizedMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public boolean addQuiz(Quiz quiz) {
        int authorID = 0;
        try (PreparedStatement statement = connection.prepareStatement(GET_USER_ID)){
            statement.setString(1, quiz.getAuthor());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    authorID = resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            logger.error("Quiz author request failed " + e.getLocalizedMessage());
        }
        if (authorID != 0) {
            try (PreparedStatement statement = connection.prepareStatement(ADD_NEW_QUIZ)){
                statement.setString(1, quiz.getSubject());
                statement.setString(2, quiz.getTopic());
                statement.setInt(3, authorID);
                return statement.execute();
            } catch (SQLException e) {
                logger.error("Quiz add request failed " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    @Override
    public List<Quiz> getQuizList() {
        List<Quiz> result = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUIZZES)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String subject = resultSet.getString("subject");
                String topic = resultSet.getString("topic");
                String login = resultSet.getString("login");
                result.add(new Quiz(id, subject, topic, login));
            }
        } catch (SQLException e) {
            logger.error("Getting quiz list request failed " + e.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public boolean update(Quiz quiz) {
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_QUIZ)) {
            statement.setString(1, quiz.getSubject());
            statement.setString(2, quiz.getTopic());
            statement.setInt(3, quiz.getId());
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Quiz update request fail " + e.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public boolean deleteQuiz(int id) {
        try(PreparedStatement statement = connection.prepareStatement(DELETE_QUIZ)) {
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Quiz delete request fail " + e.getLocalizedMessage());
        }
        return false;
    }
}
