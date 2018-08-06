package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.UserDAO;
import com.nosach.quizproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    public boolean addUser(User user) {
        if(user == null){
            return false;
        }
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = userDAO.save(user);
        return true;
    }

    public User getUser(String login) {
        User user = userDAO.getUserByLogin(login);
        return user;
    }
}
