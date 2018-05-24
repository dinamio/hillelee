package dao.impl.services;

import java.sql.SQLException;

public interface DataBaseAdapter {
    int addNewEntryToTable(String value) throws SQLException;

    Object getEntryFromTable(int i) throws SQLException;
}
