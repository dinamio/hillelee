package dao;

import dao.connector.DBConnector;
import entity.Quiz;
import entity.Subject;
import org.apache.log4j.Logger;
import service.SubjectService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOImpl implements QuizDAO {

    private static final Logger logger = Logger.getLogger(QuizDAOImpl.class);

    @Override
    public int addQuiz(Quiz quiz, int subjId) {
        Connection con = DBConnector.getConnection();


        try {
            String query = "INSERT into quizzies (theme, author, subjects_id)  VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, quiz.getTheme());
            ps.setString(2, quiz.getAuthor());
            ps.setInt(3, subjId);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int quizId = -1;
            if(rs.next())
            {
                quizId = rs.getInt(1);
            }

            logger.info("Inserted quiz, id ="+ quizId);

            return quizId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Quiz getQuiz(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT author, theme, subjects_id FROM quizzies WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                SubjectService ss = new SubjectService();
                Subject subj = ss.getSubject(rs.getInt("subjects_id"));

                return new Quiz(subj, rs.getString("theme"), rs.getString("author"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Quiz> getAllQuizzies() {
        Connection  conn = DBConnector.getConnection();
        List<Quiz> listOfQuizzies = new ArrayList<>();
        SubjectService ss = new SubjectService();

        try {
            String query = "SELECT * FROM quizzies";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                Subject subj = ss.getSubject(rs.getInt("subjects_id"));
                Quiz quiz= new Quiz(subj, rs.getString("theme"), rs.getString("author"));
                quiz.setId(rs.getInt("id"));
                listOfQuizzies.add(quiz);

                while (rs.next()){
                    subj = ss.getSubject(rs.getInt("subjects_id"));
                    quiz= new Quiz(subj, rs.getString("theme"), rs.getString("author"));
                    quiz.setId(rs.getInt("id"));
                    listOfQuizzies.add(quiz);
                }

                return listOfQuizzies;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteQuiz(int id) {
        Connection con = DBConnector.getConnection();

        try {
            String query = "DELETE from quizzies WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
