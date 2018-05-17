package dao.impl;

import dao.QuizDao;
import enteties.SubjectQuiz;

import java.awt.print.Book;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class QuizDaoImpl implements QuizDao {
    private static Logger logger = Logger.getLogger(QuizDaoImpl.class.getName());

    private static Connection connection;

    public QuizDaoImpl(){
        final String login = "user";
        final String password = "password";
        final String file = "jdbc:hsqldb:file:";
        final String connectionString = checkExistFile();

        try {Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(file + connectionString, login, password);
            } catch (ClassNotFoundException | SQLException e) {
            logger.info("Connection to DB doesn't create");
            e.printStackTrace();
        }
    }

    private String checkExistFile() {
        File file = null;
        String path = "/resources/db/db.script";
        try {
            file = new File(path);
        } catch (Exception e){}
            return path;
    }

    @Override
    public List<SubjectQuiz> getAllQuizzes() {
        List<SubjectQuiz> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Quiz");
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

return  null;
    }

    @Override
    public void insert(SubjectQuiz quiz) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into Quiz(login, subject, theme) VALUES (?,?,?,?)");
            statement.setString(1, quiz.getLogin());
            statement.setString(2, quiz.getSubject());
            statement.setString(3, quiz.getTheme());
            statement.execute();
            //statement.execute(String.format("",book.getName(),book.getAuthor()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
