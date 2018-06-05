package com.kuznetsov.dao.impl.services;


import com.kuznetsov.dao.Connector;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SubjectsDB implements DataBaseAdapter {

    @Override
    public int setToDB(String value) throws SQLException {
        String query = "SELECT id from subjects where subject = ?";

        PreparedStatement statement = Connector.getConnection().prepareStatement(query);
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
        PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        String value = rs.getString("subject");
        preparedStatement.close();
        return value;
    }
}
