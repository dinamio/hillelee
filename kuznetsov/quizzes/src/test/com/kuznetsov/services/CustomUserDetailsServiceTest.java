package com.kuznetsov.services;

import com.kuznetsov.dao.impl.daoServices.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserDao userDao;

    @Test
    public void loadUserByUsername() {

        when(userDao.getUsersByLogin(anyString())).thenReturn(null);
    }
}