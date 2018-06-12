package dao.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionHandler {
    private static Connection connection;

    private ConnectionHandler() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        } else {

            ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");

            Properties properties = new Properties();

            properties.setProperty("createDatabaseIfNotExist", resourceBundle.getString("db.createDatabaseIfNotExist"));
            properties.setProperty("user", resourceBundle.getString("db.user"));
            properties.setProperty("password", resourceBundle.getString("db.pass"));
            properties.setProperty("useUnicode", resourceBundle.getString("db.useUnicode"));
            properties.setProperty("useLegacyDatetimeCode", resourceBundle.getString("db.useLegacyDatetimeCode"));
            properties.setProperty("serverTimezone", resourceBundle.getString("db.serverTimezone"));
            properties.setProperty("noTimezoneConversionForDateType", resourceBundle.getString("db.noTimezoneConversionForDateType"));

            String url = resourceBundle.getString("db.url");


            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, properties);
            return connection;
        }
    }
}
