package dao.impl.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemesDB implements SettterToDB{
    private Connection connection;

    public ThemesDB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int setToDB(String value) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT into themes(theme) VALUES (?)");
        statement.setString(1, value);
        statement.execute();

        String query = "Select id from themes where theme = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        return rs.getInt("id");
    }


}
