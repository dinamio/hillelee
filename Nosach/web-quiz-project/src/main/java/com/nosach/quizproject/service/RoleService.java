package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.RoleDAO;
import com.nosach.quizproject.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRole (String role){
        return roleDAO.getRoleByRole(role);
    }

}
