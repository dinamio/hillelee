package dao;

import entity.Subject;
import hibernate.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.util.List;

@Component
@Qualifier("subjectHibernateDao")
public class SubjectHibernateDAOImpl implements SubjectDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(SubjectHibernateDAOImpl.class);

    @Override
    public int addSubject(Subject subject) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subject);
        logger.info("subject "+subject.getSubjectName()+" saved with id "+subject.getId());
        session.flush();
        transaction.commit();
        return subject.getId();
    }

    @Override
    public Subject getSubject(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Subject.class, id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Subject");
        List list = query.list();
        session.flush();
        transaction.commit();
        return list;
    }

    @Override
    public int getIdByName(String subj) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Subject where subjectName=:subjt");
        query.setParameter("subjt", subj);
        Subject subject = null;
        try {
             subject = (Subject) query.getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        session.flush();
        logger.info("subject "+subject +"found");
        transaction.commit();

        if (subject == null){
            return -1;
        }else{
            return subject.getId();
        }
    }
}
