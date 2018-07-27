package dao;

import entity.Registration;

import java.util.List;

public interface UsersDao {
     List<Registration> getAllUsers();

     void insertUser(Registration user);

     void deleteUser(Integer id);
}
