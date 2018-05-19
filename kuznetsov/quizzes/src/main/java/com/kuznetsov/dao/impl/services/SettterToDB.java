package dao.impl.services;

import java.sql.SQLException;

public interface SettterToDB {
    int setToDB(String value) throws SQLException;
}
