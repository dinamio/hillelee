package utils;

import logging.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtils {

    public static void transactionExecution(Connection con, PreparedStatement ps) throws SQLException {
        try {
            Log.writeInfo("Transaction is running...");
            ps.executeUpdate();
            con.commit();
            Log.writeInfo("Transaction has been commited.");
        } catch (SQLException e){
            con.rollback();
            Log.writeError(e, "Transaction has been rolled back.");
            throw e;
        }
    }
}
