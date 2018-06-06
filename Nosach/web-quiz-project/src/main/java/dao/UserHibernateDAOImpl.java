package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Component
@Qualifier("hibernateUserDAO")
public class UserHibernateDAOImpl implements UserDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        session.flush();
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User getUser(String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where login=:userLogin");
        query.setParameter("userLogin", login);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        transaction.commit();
        session.close();
        return user;
    }
}
