package dao.impl.services;

import java.sql.*;

public class SubjectsDB implements DataBaseAdapter {
    private Connection connection;

    public SubjectsDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int setToDB(String value) throws SQLException {
        String query = "SELECT id from subjects where subject = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, value);
        ResultSet rs = statement.executeQuery();

        rs.next();
        int id = rs.getInt(1);
        statement.close();
        return id;
    }

    @Override
    public String getFromDB(int idFromQuiz) throws SQLException {
        String query = "Select subject from subjects where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        String value = rs.getString("subject");
        preparedStatement.close();
        return value;
    }
}
