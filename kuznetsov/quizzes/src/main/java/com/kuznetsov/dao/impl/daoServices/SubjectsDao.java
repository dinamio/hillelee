package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.SubjectsEntity;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SubjectsDao {
    public SubjectsEntity getSubjectsFromDb(String subject) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        SubjectsEntity subjectsEntity = session.byNaturalId(SubjectsEntity.class).using("subject", subject).load();

        return subjectsEntity;
    }

    public SubjectsEntity getSubjectsFromDb(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        SubjectsEntity subjectsEntity = session.get(SubjectsEntity.class, id);

        return subjectsEntity;
    }
}
