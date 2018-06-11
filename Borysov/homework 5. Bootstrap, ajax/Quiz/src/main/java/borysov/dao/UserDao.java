package borysov.dao;

import borysov.entity.User;
import borysov.exception.DAOException;

import java.sql.SQLException;

public interface UserDao {
    User getUserFromDB(String login, String password) throws SQLException, DAOException;

    void addNewUserToDB(User newUser);
}
