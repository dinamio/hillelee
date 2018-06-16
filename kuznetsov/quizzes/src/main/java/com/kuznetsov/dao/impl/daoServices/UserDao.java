package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    private final Session session;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public Users getUserFromDB(String sessionLogin) {

        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        Users users = (Users) criteria.add(Restrictions.eq("login", sessionLogin))
                .uniqueResult();
        transaction.commit();

        return users;
    }

    public Users getUserFromDB(Integer id) {

        Transaction transaction = session.beginTransaction();
        Users users = session.get(Users.class, id);
        transaction.commit();

        return users;
    }

    public void saveCredentialsToDB(Users users) {

        Transaction transaction = session.beginTransaction();
        session.save(users);
        transaction.commit();
    }
}
