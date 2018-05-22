package dao.impl.services;

import java.sql.*;

public class ThemesDB implements DataBaseAdapter {
    private Connection connection;

    public ThemesDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int setToDB(String value) throws SQLException {
        String query = "INSERT into themes(theme) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, value);
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        statement.close();
        return id;
    }

    @Override
    public String getFromDB(int idFromQuiz) throws SQLException {
        String query = "Select theme from themes where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        return rs.getString("theme");
    }

}
