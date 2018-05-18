package dao.impl;

import dao.QuizDao;
import enteties.SubjectQuiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class QuizDaoImpl implements QuizDao {
    private static Logger logger = Logger.getLogger(QuizDaoImpl.class.getName());

    private static Connection connection;
    private String userID;

    public QuizDaoImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            logger.info("Can not connect!!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SubjectQuiz> getAllQuizzes() {
        List<SubjectQuiz> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Quizes join users on quizes.login = users.idusers");
            while (resultSet.next()) {
                SubjectQuiz quiz = new SubjectQuiz();
                quiz.setId(resultSet.getInt("id"));
                quiz.setLogin(resultSet.getString("login"));
                quiz.setSubject(resultSet.getString("subject"));
                quiz.setTheme(resultSet.getString("theme"));
                quiz.setQuestionMap(getQuestionsFromDB(resultSet.getString("questions")));
                result.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Map<String, String> getQuestionsFromDB(String questions) {

        return null;
    }

    public Map<String, String> getCredentials() {
        Map<String, String> savedCredentials = new HashMap<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Users");
            while (resultSet.next()) {
                String login = (resultSet.getString("login"));
                String pwd = (resultSet.getString("pwd"));
                savedCredentials.put(login, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedCredentials;
    }

    public void saveCredentials(String login, String pwd) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into Users(login, pwd) VALUES (?,?)");

            statement.setString(1, login);
            statement.setString(2, pwd);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Can't save credentials to bd");
        }
    }


    @Override
    public void insert(SubjectQuiz quiz) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into Quiz(login, subject, theme) VALUES (?,?,?)");
            statement.setString(1, userID);
            statement.setString(2, quiz.getSubject());
            statement.setString(3, quiz.getTheme());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
