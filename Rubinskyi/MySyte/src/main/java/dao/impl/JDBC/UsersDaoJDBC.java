package dao.impl.JDBC;

import entity.Registration;
import dao.UsersDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("JDBC")
public class UsersDaoJDBC implements UsersDao {
    private static Connection connection;
    private String urlDB = "jdbc:mysql://localhost:3306/quiz" +
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    private static Logger logger = Logger.getLogger(UsersDaoJDBC.class);

    public UsersDaoJDBC(){
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
    public List<Registration> getAllUsers() {
        List<Registration> resultUser = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quiz.users");
            while (resultSet.next()){
                Registration user = new Registration();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                resultUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(resultUser);
        return resultUser;
    }

    @Override
    public void insertUser(Registration user) {
        try(Statement statement = connection.createStatement()){
            statement.execute(String.format("INSERT INTO quiz.users (login, password) VALUES ('%s', '%s')"
                    ,user.getLogin(), user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try(Statement statement = connection.createStatement()){
            statement.execute("DELETE FROM quiz.users WHERE id ="+ id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
