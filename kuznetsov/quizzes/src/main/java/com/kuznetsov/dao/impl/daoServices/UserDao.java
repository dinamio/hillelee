package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.User;
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

    public User getUserFromDB(String sessionLogin) {

        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("login", sessionLogin))
                .uniqueResult();
        transaction.commit();

        return user;
    }

    public User getUserFromDB(Integer id) {

        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();

        return user;
    }

    public void saveCredentialsToDB(User user) {

        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }
}
