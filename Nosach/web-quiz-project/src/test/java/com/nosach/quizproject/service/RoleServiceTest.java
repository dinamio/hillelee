package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.RoleDAO;
import com.nosach.quizproject.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RoleServiceTest {

    @InjectMocks
    RoleService roleService = new RoleService();

    @Mock
    RoleDAO roleDAO;

    @Test
    public void shouldReturnNullForNullRole(){
        when(roleDAO.getRoleByRole(null)).thenReturn(null);
        Role result;

        result = roleService.getRole(null);

        assertEquals(null, result);
    }
}
