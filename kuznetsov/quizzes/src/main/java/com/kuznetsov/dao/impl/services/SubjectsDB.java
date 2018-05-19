package dao.impl.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectsDB implements SettterToDB{
    private Connection connection;

    public SubjectsDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int  setToDB(String value) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT into subjects(subject) VALUES (?)");
        statement.setString(1, value);
        statement.execute();

        String query = "Select id from subjects where subject = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        return rs.getInt("id");
    }
}
