package borysov.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionPool {

	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

	/**
	 * fields for describing connection and pool
	 */
	private final static String url = "jdbc:mysql://localhost:3306/quiz_db?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private final static String nameUrl = "root";
	private final static  String passwordUrl = "root";
	private static Connection connection = null;

	public static Connection getConnection() {
        LOGGER.info("Get connection");
		if (connection == null) {
            try {
                connection = getInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
		return connection;

	}

	public static Connection getInstance() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		try {
			connection = DriverManager.getConnection(url, nameUrl, passwordUrl);

		} catch (SQLException e1) {
			LOGGER.error("Connection Failed! Check output console",e1);

		}

		if (connection != null) {
			LOGGER.info("take control your database");
		} else {
			LOGGER.error("Failed to make connection!");
		}
		LOGGER.info("INSTANCE");
		return connection;
	}
}
