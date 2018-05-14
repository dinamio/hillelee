package dao;

import dao.connector.DBConnector;
import entity.Question;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO {

    private static final Logger logger = Logger.getLogger(QuestionDAOImpl.class);

    @Override
    public int addQuestion(Question question, int quizId) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into questions (issue, quiz_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, question.getIssue());
            ps.setInt(2, quizId);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            int questId = -1;
            if(rs.next())
            {
                questId = rs.getInt(1);
            }

            logger.info("Inserted question, id ="+ questId);

            return questId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Question getQuestion(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT issue, quiz_id FROM questions WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Question(rs.getString("issue"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getQuestionsForQuiz(int quizId) {

        Connection  conn = DBConnector.getConnection();
        List<Question> listOfQuestions = new ArrayList<>();

        try {
            String query = "SELECT issue FROM questions WHERE quiz_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfQuestions.add(new Question(rs.getString("issue")));

                while(rs.next()){
                    listOfQuestions.add(new Question(rs.getString("issue")));
                }
                return listOfQuestions;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
