package dao.impl;

import dao.UserDao;
import dao.connector.ConnectionHandler;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {
    private Connection connection;
    private Logger logger;

    private static final String ADD_NEW_USER_INTO_DB = "INSERT INTO user (full_name, login, password) VALUES(?,?,?)";
    private static final String VALIDATE_USER_EXISTS_BY_GETTING_ID = "SELECT id FROM user WHERE login=? IS NOT NULL";
    private static final String GET_ENCRYPTED_USER_PASS = "SELECT password FROM user WHERE login=? IS NOT NULL";
    private static final String UPDATE_ENCRYPTED_USER_PASS = "UPDATE user SET password=? WHERE login=?";

    public UserDaoImpl() {
        this.logger = Logger.getLogger(this.getClass());
        try {
            this.connection = ConnectionHandler.getConnection();
        } catch (SQLException e) {
            logger.error("Connection failed " + e.getLocalizedMessage(), e.fillInStackTrace());
        } catch (ClassNotFoundException e) {
            logger.error("Driver not found " + e.getLocalizedMessage(), e.fillInStackTrace());
        }
    }

    @Override
    public boolean addUser(User user) {
        try(PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER_INTO_DB)) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            return statement.execute();
        } catch (SQLException e) {
            logger.error("Create user error", e.getNextException());
        }
        return false;
    }

    @Override
    public String getUserPass(String login) {
        try(PreparedStatement statement = connection.prepareStatement(GET_ENCRYPTED_USER_PASS)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            }
        } catch (SQLException e) {
            logger.error("User pass getting error", e.getNextException());
        }
        return "";
    }

    @Override
    public boolean validateUserExists(String login) {
        try(PreparedStatement statement = connection.prepareStatement(VALIDATE_USER_EXISTS_BY_GETTING_ID)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            logger.error("User's login validation failed", e.getNextException());
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_ENCRYPTED_USER_PASS)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getLogin());
            return statement.execute();
        } catch (SQLException e) {
            logger.error("User password update error", e.getNextException());
        }
        return false;
    }
}
