package dao;

import entity.Quiz;
import hibernate.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("quizHibernateDao")
public class QuizHibernateDAOImpl implements QuizDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(QuizHibernateDAOImpl.class);


    @Override
    public int addQuiz(Quiz quiz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        session.flush();
        transaction.commit();
        return quiz.getId();
    }

    @Override
    public Quiz getQuiz(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Quiz quiz = session.get(Quiz.class, id);
        session.flush();
        transaction.commit();
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuizzies() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Quiz");
        List<Quiz> quizList = query.list();
        session.flush();
        transaction.commit();
        return quizList;
    }

    @Override
    public void deleteQuiz(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Quiz where id=:quizId");
        query.setParameter("quizId", id);
        query.executeUpdate();
        session.flush();
        transaction.commit();
    }
}
