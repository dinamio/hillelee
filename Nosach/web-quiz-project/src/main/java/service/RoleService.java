package service;

import dao.RoleDAO;
import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public Role getRole (String role){
        return roleDAO.getRole(role);
    }

}
