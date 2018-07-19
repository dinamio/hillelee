package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends CrudRepository<Questions, Integer>  {

    public List getAllByTheme(Integer id);
}
