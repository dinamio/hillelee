package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Quizzes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuizDao extends CrudRepository<Quizzes, Integer> {


    @Transactional
    @Modifying
    public void removeQuizzesById(int id);

}

