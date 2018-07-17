package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    public User getUserByLogin(String sessionLogin) ;

    public User getUserById(Integer id);

    /*@Transactional
    @Modifying
    public void saveUser(User user);*/
}
