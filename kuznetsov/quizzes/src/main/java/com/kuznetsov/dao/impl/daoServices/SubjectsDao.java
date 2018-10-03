package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsDao extends CrudRepository<Subjects, Integer> {
    Subjects getSubjectsBySubject(String subject);
}
