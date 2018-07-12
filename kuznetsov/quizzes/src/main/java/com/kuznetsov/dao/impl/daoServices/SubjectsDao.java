package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Subjects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectsDao {
    private final Session session;

    @Autowired
    public SubjectsDao(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public Subjects getSubjectsFromDb(String subject) {

        return session.byNaturalId(Subjects.class).using("subject", subject).load();
    }

    public Subjects getSubjectsFromDb(Integer id) {

        return session.get(Subjects.class, id);
    }
}
