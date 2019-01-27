package dao.impl;

import dao.UsersDao;
import entity.Registration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import util.HibernateUtils;

import java.util.List;

@Repository
@Qualifier("hibernate")
public class UsersDaoImpl implements UsersDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<Registration> getAllUsers() {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM entity.Registration");
            transaction.commit();
            return query.list();
        } catch (Throwable ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(ex + " " + ex.getCause());
            throw ex;
        }
    }

    @Override
    public void insertUser(Registration user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            session.save(user);
            session.flush();
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(ex + " " + ex.getCause());
            throw ex;
        }
    }

    @Override
    public void deleteUser(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            Registration registration = session.get(Registration.class, id);
            session.delete(registration);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(ex + " " + ex.getCause());
            throw ex;
        }
    }

    /* !?!? This is method without "try with resources. Need as memory */
    /*@Override
    public List<Registration> getAllUsers() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM entity.Registration");
            transaction.commit();
            return query.list();
        }
        catch (Throwable ex){
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(ex + " " + ex.getCause());
            throw ex;
        }
        finally {
            session.close();
        }
    }*/
}
