package com.quiz.borysov.quizboot.dao;

import com.quiz.borysov.quizboot.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface UserDao extends CrudRepository<User,Integer>{
    User findUserByLogin (String s);
}
