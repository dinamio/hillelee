package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.UsersEntity;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public UsersEntity getUserFromDB(String sessionLogin) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersEntity usersEntity = session.byNaturalId(UsersEntity.class).using("login", sessionLogin).load();
        transaction.commit();

        return usersEntity;
    }

    public UsersEntity getUserFromDB(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersEntity usersEntity = session.get(UsersEntity.class, id);
        transaction.commit();

        return usersEntity;
    }

    public void saveCredentialsToDB(UsersEntity usersEntity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usersEntity);
        transaction.commit();
    }
}
