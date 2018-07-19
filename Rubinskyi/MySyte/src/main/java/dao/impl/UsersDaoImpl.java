package dao.impl;

import Entities.Registration;
import dao.UsersDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {
    private static Connection connection;
    private String urlDB = "jdbc:mysql://localhost:3306/quiz" +
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    private static Logger logger = Logger.getLogger(UsersDaoImpl.class);

    public UsersDaoImpl(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
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

   /* public boolean addRegisteredUser(String myLogin, String myPassword){
        boolean isAdded = false;
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO quiz.users (login, password) VALUES ('myLogin', 'myPassword')");
            isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }*/

    @Override
    public void insertUser(Registration user) {
        try(Statement statement = connection.createStatement()){
            statement.execute(String.format("INSERT INTO quiz.users (login, password) VALUES ('%s', '%s')"
                    ,user.getLogin(), user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
