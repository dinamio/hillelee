package dao.impl.JDBC;

import entity.QuizTopic;
import entity.Registration;
import dao.QuizDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("JDBC")
public class QuizDaoJDBC implements QuizDao {

    private static Connection connection;
    private String urlDB = "jdbc:mysql://localhost:3306/quiz" +
            "?verifyServerCertificate=false"+
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";


    private static Logger logger = Logger.getLogger(QuizDaoJDBC.class);

    public QuizDaoJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(urlDB, "root", "qwerty3011");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Problem with connection", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Registration getById(int id){
        Registration registration = new Registration();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz.users WHERE id="+id);
            while (resultSet.next()) {
                registration.setId(resultSet.getInt("id"));
                registration.setLogin(resultSet.getString("login"));
                registration.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registration;
    }

    @Override
    public List<QuizTopic> getAllQuizzes() {
        List<QuizTopic> resultQuiz = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz.quizes ORDER BY topic, theme");
            while (resultSet.next()) {

                QuizTopic quizTopic = new QuizTopic();
                quizTopic.setId(resultSet.getInt("id"));
                quizTopic.setTopic(resultSet.getString("topic"));
                quizTopic.setTheme(resultSet.getString("theme"));
                quizTopic.setCreator(getById(resultSet.getInt("id_creator")));

                resultQuiz.add(quizTopic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultQuiz;
    }

    @Override
    public void insertQuiz(QuizTopic quizTopic, Registration currentUser) {
        Integer id = null;
        try (Statement statement = connection.createStatement()){
            ResultSet idRS = statement.executeQuery(String.format("SELECT id FROM quiz.users WHERE login='%s'", currentUser.getLogin()));
            while (idRS.next()){
                id = idRS.getInt("id");
                }
            statement.execute(String.format("INSERT INTO quiz.quizes (topic, theme, id_creator) VALUES ('%s', '%s', '%d')"
                    ,quizTopic.getTopic(), quizTopic.getTheme(), id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM quiz.quizes WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
