package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Subjects;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SubjectsDao {
    public Subjects getSubjectsFromDb(String subject) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Subjects subjects = session.byNaturalId(Subjects.class).using("subject", subject).load();

        return subjects;
    }

    public Subjects getSubjectsFromDb(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Subjects subjects = session.get(Subjects.class, id);

        return subjects;
    }
}
