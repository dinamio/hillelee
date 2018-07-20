package dao;

import Entities.Registration;

import java.util.List;

public interface UsersDao {
     List<Registration> getAllUsers();

     void insertUser(Registration user);
}
