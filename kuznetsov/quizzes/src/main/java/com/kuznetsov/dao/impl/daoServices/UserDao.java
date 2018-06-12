package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Users;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public Users getUserFromDB(String sessionLogin) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        Users users = (Users) criteria.add(Restrictions.eq("login", sessionLogin))
                .uniqueResult();
        transaction.commit();

        return users;
    }

    public Users getUserFromDB(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Users users = session.get(Users.class, id);
        transaction.commit();

        return users;
    }

    public void saveCredentialsToDB(Users users) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(users);
        transaction.commit();
    }
}
