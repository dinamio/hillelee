package connection;

import logging.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static ConnectionUtil instance;
    private String url;
    private String user;
    private String pass;

    private ConnectionUtil(){
        try{
            Class.forName("org.postgresql.Driver");
            url = "jdbc:postgresql://localhost/postgres";
            user = "postgres";
            pass = "postgres";
        } catch (ClassNotFoundException e){
            Log.writeError(e, "org.postgresql.Driver is not founded");
        }
    }

    public static Connection getConnection() throws SQLException {
        synchronized (ConnectionUtil.class){
            if (instance == null){
                instance = new ConnectionUtil();
            }
        }
        return DriverManager.getConnection(instance.url, instance.user, instance.pass);
    }

    public static void close(Connection connection) {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
