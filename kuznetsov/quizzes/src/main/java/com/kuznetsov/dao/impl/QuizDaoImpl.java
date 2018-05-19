package dao.impl;

import dao.QuizDao;
import dao.impl.services.*;
import enteties.SubjectQuiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class QuizDaoImpl implements QuizDao {
    private static Logger logger = Logger.getLogger(QuizDaoImpl.class.getName());

    private DataBaseAdapter subjectsDB;
    private DataBaseAdapter themesDB;
    private DataBaseAdapter usersDB;
    private QuestionsDB questionsDB;

    private static Connection connection;

    public QuizDaoImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "user", "user");
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            logger.info("Can not connect to data base");
            throw new RuntimeException(e);
        }

        subjectsDB = new SubjectsDB(connection);
        themesDB = new ThemesDB(connection);
        usersDB = new UsersDB(connection);
        questionsDB = new QuestionsDB(connection);
    }

    @Override
    public List<SubjectQuiz> getAllQuizzesFromDB() {
        List<SubjectQuiz> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select id, login, subject, theme, questions from quizzes");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int login = resultSet.getInt("login");
                int subject = resultSet.getInt("subject");
                int theme = resultSet.getInt("theme");
                int questions = resultSet.getInt("questions");

                String sLogin = usersDB.getFromDB(login);
                String sSubject = subjectsDB.getFromDB(subject);
                String sTheme = themesDB.getFromDB(theme);
                Map<String, String> mQuestions = questionsDB.getFromDB(questions);

                SubjectQuiz quiz = new SubjectQuiz();

                quiz.setId(id);
                quiz.setLogin(sLogin);
                quiz.setSubject(sSubject);
                quiz.setTheme(sTheme);
                quiz.setQuestionMap(mQuestions);

                result.add(quiz);
            }

            resultSet.close();

        } catch (SQLException e) {

            e.printStackTrace();
            logger.info("Can't get list of quizzes from data base");
        }
        return result;
    }

    @Override
    public void addNewQuizToDB(SubjectQuiz quiz) {

        String query = "INSERT into quizzes(login, subject, theme) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, usersDB.setToDB(quiz.getLogin()));
            statement.setInt(2, subjectsDB.setToDB(quiz.getSubject()));
            statement.setInt(3, themesDB.setToDB(quiz.getTheme()));

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int auto_id = rs.getInt(1);

            statement.close();

            String questionsQuery = "UPDATE quizzes set questions = ? where id = ?";

            PreparedStatement questionsStatement = connection.prepareStatement(questionsQuery);

            questionsStatement.setInt(1, auto_id);
            questionsStatement.setInt(2, auto_id);

            questionsStatement.executeUpdate();

            questionsStatement.close();

            questionsDB.setToDB(auto_id, quiz.getQuestionMap());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Can't add new quiz to data base");
        }
    }

    @Override
    public void removeQuizFromDB(int id) {

        PreparedStatement preparedStatement;
        String query = "DELETE from quiz.quizzes WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isCredentialsCons(String sessionLogin, String sessionPwd) {

        try {
            String query = "Select id, login, pwd from Users where login = ? AND pwd = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, sessionLogin);
            preparedStatement.setString(2, sessionPwd);

            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {

                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("login or password is incorrect");
        }
        return true;
    }

    public void saveCredentials(String login, String pwd) {

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement("INSERT into Users(login, pwd) VALUES (?,?)");

            statement.setString(1, login);
            statement.setString(2, pwd);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Can't save credentials to data base");
        }
    }
}
