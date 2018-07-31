package com.quiz.borysov.quizboot.service;


import com.quiz.borysov.quizboot.dao.UserDao;
import com.quiz.borysov.quizboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
     UserDao userDao;

    @Test
    public void shouldRegisterNewUser() {
        when(userDao.findUserByLogin(anyString())).thenReturn(new User("login", "password","name"));

        User user = userDao.findUserByLogin("login");
        assertEquals("name", user.getName());
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowNPEWhenGetNull() {
        userService.registerUser(null);
    }
}
