package dao.impl.services;

import java.sql.SQLException;

public interface DataBaseAdapter {
    int setToDB(String value) throws SQLException;

    String getFromDB(int i) throws SQLException;
}
