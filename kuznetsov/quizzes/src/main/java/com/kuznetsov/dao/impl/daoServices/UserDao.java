package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<Users, Integer> {

    public Users getUsersByLogin(String sessionLogin) ;

    public Users getUsersById(Integer id);
}
