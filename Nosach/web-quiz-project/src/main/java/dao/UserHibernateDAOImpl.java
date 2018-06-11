package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Qualifier("hibernateUserDAO")
public class UserHibernateDAOImpl implements UserDAO {

    final Session session;

    public UserHibernateDAOImpl(@Autowired SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public boolean addUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        session.flush();
        transaction.commit();
        return true;
    }

    @Override
    public User getUser(String login) {
        Query query = session.createQuery("from User where login=:userLogin");
        query.setParameter("userLogin", login);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return user;
    }
}
