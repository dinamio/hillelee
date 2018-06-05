package com.kuznetsov.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection connection;

    public static void createConnection(String dbUrl,String dbusername,String dbPassword){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbusername, dbPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        if(connection !=null){
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
