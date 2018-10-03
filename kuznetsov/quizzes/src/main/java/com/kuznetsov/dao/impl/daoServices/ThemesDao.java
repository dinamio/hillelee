package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Themes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemesDao extends CrudRepository<Themes, Integer> {
}
