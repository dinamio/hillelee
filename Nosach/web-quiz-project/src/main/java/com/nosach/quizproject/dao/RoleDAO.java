package com.nosach.quizproject.dao;

import com.nosach.quizproject.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends CrudRepository<Role, Integer>{

    public Role getRoleByRole(String role);
}
