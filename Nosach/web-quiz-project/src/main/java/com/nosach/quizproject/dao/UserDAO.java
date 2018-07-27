package com.nosach.quizproject.dao;

import com.nosach.quizproject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{

    public User getUserByLogin (String login);
}
