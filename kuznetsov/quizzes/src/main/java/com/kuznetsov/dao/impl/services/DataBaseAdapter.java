package com.kuznetsov.dao.impl.services;

import java.sql.SQLException;

public interface DataBaseAdapter {
    int setToDB(String value) throws SQLException;

    Object getFromDB(int i) throws SQLException;
}
