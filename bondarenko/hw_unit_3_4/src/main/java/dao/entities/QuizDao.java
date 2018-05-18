package dao.entities;

import connection.ConnectionUtil;
import dao.Entity;
import dao.Operation;
import dao.Vendor;
import logging.Log;
import model.Quiz;
import utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class QuizDao extends AbstractEntity{

    public QuizDao(Vendor vendor, Entity entity) {
        super(vendor, entity);
    }

    public void create(Quiz quiz) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Creating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.CREATE));
            ps.setString(1, quiz.getName());
            ps.setString(2, quiz.getDescription());
            ps.setString(3, quiz.getAuthor());
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Deleting finished.");
        } catch (SQLException e) {
            Log.writeError(String.format("Creating error. Quiz id={%s}"));
        }
    }


    public Optional<Quiz> get(String id) {
        Quiz quiz = null;
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo(String.format("Start of data extracting. Quiz id: {%s}", id));
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.READ));
            ps.setLong(1, Long.valueOf(id));
            ResultSet rs = ps.executeQuery();
            rs.next();
            quiz = new Quiz(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
            );
            Log.writeInfo(String.format("Data extracting was finished. Quiz id: {%s}", id));
        } catch (SQLException e) {
            Log.writeError(e,String.format("Unable to load quiz with id {%s}", id));
        }
        return Optional.ofNullable(quiz);
    }


    public Collection<Quiz> getAll() {
        Collection<Quiz> quizzes = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Start of data extracting...");
            Connection conn = ConnectionUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getStatements().get(Operation.READ_ALL));
            while (rs.next()){
                quizzes.add(new Quiz(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3))
                );
            }
            Log.writeInfo("Data extracting finished.");
        } catch (SQLException e) {
            Log.writeError(e,"Loading error.");
        }
        return quizzes;
    }


    public void update(Quiz quiz) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Updating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.UPDATE));
            ps.setLong(1, Long.valueOf(quiz.getName()));
            ps.setLong(2, Long.valueOf(quiz.getDescription()));
            ps.setLong(3, Long.valueOf(quiz.getAuthor()));
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Updating finished");
        } catch (SQLException e) {
            Log.writeError(String.format("Updating error. Quiz : {%s}", quiz));
        }
    }
}
