package dao;

import dao.connector.DBConnector;
import entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public void addUser(User user) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into USERS (login, password, name, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getEmail());

            logger.info("Adding user "+user.getLogin()+" to db");

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String login) {

        Connection  conn = DBConnector.getConnection();
        logger.info("DB Connection estableshed for getting user "+login);

        try {
            String query = "SELECT login, password, name, email FROM users WHERE login= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                logger.info("User "+login+" not found in db");
                return null;
            }
            else {
                return new User(rs.getString("login"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getString("email"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}


