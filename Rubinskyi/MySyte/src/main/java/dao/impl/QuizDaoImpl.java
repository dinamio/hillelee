package dao.impl;

import Entities.QuizTopic;
import Entities.Registration;
import dao.QuizDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizDaoImpl implements QuizDao {

    private static Connection connection;
    private String urlDB = "jdbc:mysql://localhost:3306/quiz" +
            "?verifyServerCertificate=false"+
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";


    private static Logger logger = Logger.getLogger(QuizDaoImpl.class);

    public QuizDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(urlDB, "root", "qwerty3011");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Problem with connection", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuizTopic> getAllQuizzes() {
        List<QuizTopic> resultQuiz = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz.quizes ORDER BY topic, theme");
            while (resultSet.next()) {
                QuizTopic quizTopic = new QuizTopic();
                quizTopic.setId(resultSet.getInt("id"));
                quizTopic.setQuizSubject(resultSet.getString("topic"));
                quizTopic.setQuizTopic(resultSet.getString("theme"));
                quizTopic.setIdCreator(resultSet.getInt("id_creator"));

                resultQuiz.add(quizTopic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // System.out.println(resultQuiz);
        return resultQuiz;
    }

    @Override
    public void insertQuiz(QuizTopic quizTopic){
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("INSERT INTO quiz.quizes (topic, theme) VALUES ('%s', '%s')"
                    ,quizTopic.getQuizSubject(), quizTopic.getQuizTopic()));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertQuiz(QuizTopic quizTopic, Registration currentUser) {
        Integer id = null; // needed one declaration */
        try (Statement statement = connection.createStatement()){
            ResultSet idRS = statement.executeQuery(String.format("SELECT id FROM quiz.users WHERE login='%s'", currentUser.getLogin()));
            while (idRS.next()){
                id = idRS.getInt("id");
                System.out.println(id);}
            statement.execute(String.format("INSERT INTO quiz.quizes (topic, theme, id_creator) VALUES ('%s', '%s', '%d')"
                    ,quizTopic.getQuizSubject(), quizTopic.getQuizTopic(), id));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

 /*   @Override
    public void deleteById(Integer id) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM quiz.quizes WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
