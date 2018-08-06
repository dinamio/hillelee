package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService();

    @Mock
    UserDAO userDAO;

    @Test
    public void shouldReturnFalseWhenUserIsNull(){

        when(userDAO.save(null)).thenReturn(null);
        Boolean result = userService.addUser(null);
        assertEquals(false, result);
    }



}
