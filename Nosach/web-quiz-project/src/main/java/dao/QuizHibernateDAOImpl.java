package dao;

import entity.Quiz;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Qualifier("quizHibernateDao")
public class QuizHibernateDAOImpl implements QuizDAO{

    final Session session;
    Logger logger = Logger.getLogger(QuizHibernateDAOImpl.class);

    public QuizHibernateDAOImpl(@Autowired SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public int addQuiz(Quiz quiz) {
        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        session.flush();
        transaction.commit();
        return quiz.getId();
    }

    @Override
    public Quiz getQuiz(int id) {
        return session.get(Quiz.class, id);
    }

    @Override
    public List<Quiz> getAllQuizzies() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Quiz");
        List<Quiz> quizList = query.list();
        session.flush();
        transaction.commit();
        return quizList;
    }

    @Override
    public void deleteQuiz(int id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Quiz where id=:quizId");
        query.setParameter("quizId", id);
        query.executeUpdate();
        session.flush();
        transaction.commit();
    }
}
