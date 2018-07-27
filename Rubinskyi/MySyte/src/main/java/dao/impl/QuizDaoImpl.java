package dao.impl;

import dao.QuizDao;
import entity.QuizTopic;
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
public class QuizDaoImpl implements QuizDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<QuizTopic> getAllQuizzes() {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM entity.QuizTopic");
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

    /* TODO setString() is deprecated, have to change method to use */
    private Registration findUserByLogin(Registration user){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
/*            Query query = session.createQuery("FROM entity.Registration reg WHERE reg.login=:login").setString("login", user.getLogin());*/
            Query query = session.createQuery("FROM entity.Registration reg WHERE reg.login=:login").setParameter("login", user.getLogin());
            return (Registration) query.getSingleResult();
        }
    }


    @Override
    public void insertQuiz(QuizTopic quizTopic, Registration currentUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            currentUser.setId(findUserByLogin(currentUser).getId());
            quizTopic.setCreator(currentUser);
            session.save(quizTopic);
            transaction.commit();
        }
        catch (Throwable ex){
            logger.info(ex + " "+ ex.getCause());
            throw ex;
        }
    }

    @Override
    public void deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            QuizTopic quizTopic = session.get(QuizTopic.class, id);
            session.delete(quizTopic);
            transaction.commit();
        } catch (Throwable ex){
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(ex + " " + ex.getCause());
            throw ex;
        }
    }
}
