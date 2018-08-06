package com.nosach.quizproject.dao;

import com.nosach.quizproject.entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SubjectDAO extends CrudRepository<Subject, Integer>{

    public Subject findBySubjectName(String subject);

    public Subject findSubjectById(Integer id);

}
