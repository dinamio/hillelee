package borysov.dao.impl;

import borysov.dao.ConnectionPool;
import borysov.dao.UserDao;
import borysov.entity.User;
import borysov.exception.DAOException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserDaoImpl implements UserDao {

    private static Connection connection = ConnectionPool.getConnection();
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public void addNewUserToDB(User newUser) {
        LOGGER.info("addNewUserToDB");
        String INSERT_NEW = "INSERT INTO users (login, password, name)  VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, newUser.getLogin());
            preparedStatement.setString(2, newUser.getPassword());
            preparedStatement.setString(3, newUser.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("addNewUserToDB error", e);
            throw new DAOException();
        }

    }


    public User getUserFromDB(String login, String password) throws SQLException {
        User user = null;

        String SELECT = "SELECT * FROM users WHERE login=? AND password=?";

        PreparedStatement statement = connection.prepareStatement(SELECT);
        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            return user;
        } else {
            LOGGER.error("getUserByLoginAndPass error");
            throw new DAOException("DAOException while UserDaoImpl.getUserByLoginAndPass()");
        }
    }
}
