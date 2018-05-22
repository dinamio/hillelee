package dao.impl.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UsersDB implements DataBaseAdapter {
    private Logger logger = Logger.getLogger(getClass().getName());
    private Connection connection;

    public UsersDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int setToDB(String value) throws SQLException {

        String query = "Select id from users where login = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int result = rs.getInt("id");
        preparedStatement.close();
        return result;
    }


    public Map<String, String> getFromDB(int idFromQuiz) {

        Map<String, String> result = new HashMap<>();
        String query = "Select login, pwd from Users where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {

            String login = rs.getString("login");
            String pwd = rs.getString("pwd");

            result.put(login, pwd);
        } else
            return null;
        preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public String getSalt(String login){
        String result = null;
        String query = "Select salt from users where login = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, login);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
            try {
                result = rs.getString("salt");
            } catch (SQLException e) {
                e.printStackTrace();
                logger.info("salt don't find");
                return null;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

}
