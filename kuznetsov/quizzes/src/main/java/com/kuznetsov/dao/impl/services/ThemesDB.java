package com.kuznetsov.dao.impl.services;

import com.kuznetsov.dao.Connector;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ThemesDB implements DataBaseAdapter {

    @Override
    public int setToDB(String value) throws SQLException {
        String query = "INSERT into themes(theme) VALUES (?)";

        PreparedStatement statement = Connector.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
        PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        return rs.getString("theme");
    }

}
