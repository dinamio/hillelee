package dao.impl.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDB implements SettterToDB{
    private Connection connection;

    public UsersDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int  setToDB(String value) throws SQLException {

        String query = "Select id from users where login = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int result = rs.getInt("id");
        preparedStatement.close();
        return result;
    }
}
