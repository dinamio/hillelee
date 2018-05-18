package dao;

import dao.connector.DBConnector;
import entity.Answer;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO {

    private static final Logger logger = Logger.getLogger(QuestionDAOImpl.class);

    @Override
    public int addAnswer(Answer answer, int questionId) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into answers (answer, correct, question_id) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, answer.getAnswer());
            ps.setBoolean(2, answer.isCorrect());
            ps.setInt(3, questionId);


            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            int answerId = -1;
            if(rs.next())
            {
                answerId = rs.getInt(1);
            }

            logger.info("Inserted answer, id ="+ answerId);

            return answerId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Answer getAnswer(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT answer, correct, question_id FROM answers WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Answer(rs.getString("answer"),
                                    rs.getBoolean("correct"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Answer> getAnswersForQuestion(int questionId) {

        Connection  conn = DBConnector.getConnection();
        List<Answer> listOfAnswers = new ArrayList<>();

        try {
            String query = "SELECT answer, correct FROM questions WHERE question_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, questionId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfAnswers.add(new Answer(rs.getString("answer"), rs.getBoolean("correct")));

                while(rs.next()){
                    listOfAnswers.add(new Answer(rs.getString("answer"), rs.getBoolean("correct")));
                }
                return listOfAnswers;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
