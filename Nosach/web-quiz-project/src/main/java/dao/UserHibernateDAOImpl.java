package dao;


import entity.User;
import org.apache.log4j.Logger;
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

    Logger logger = Logger.getLogger(UserHibernateDAOImpl.class);

    @Autowired
    public UserHibernateDAOImpl(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public boolean addUser(User user) {
        logger.info("Adding user "+user.getLogin());
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
        }catch(Exception ex) {
            return true;
        }
        session.flush();
        transaction.commit();
        return true;
    }

    @Override
    public User getUser(String login) {
        logger.info("Getting user "+login);
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
