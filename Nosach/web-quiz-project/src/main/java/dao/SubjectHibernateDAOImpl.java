package dao;

import entity.Subject;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Qualifier("subjectHibernateDao")
public class SubjectHibernateDAOImpl implements SubjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    final Session session;
    Logger logger = Logger.getLogger(SubjectHibernateDAOImpl.class);

    public SubjectHibernateDAOImpl(@Autowired SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public int addSubject(Subject subject) {
        Transaction transaction = session.beginTransaction();
        session.save(subject);
        logger.info("subject "+subject.getSubjectName()+" saved with id "+subject.getId());
        session.flush();
        transaction.commit();
        return subject.getId();
    }

    @Override
    public Subject getSubject(int id) {
        return session.get(Subject.class, id);
    }

    @Override
    public List<Subject> getAllSubjects() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Subject");
        List list = query.list();
        session.flush();
        transaction.commit();
        return list;
    }

    @Override
    public int getIdByName(String subj) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> criteria = criteriaBuilder.createQuery(Subject.class);
        Root<Subject> subjectRoot = criteria.from(Subject.class);
        criteria.select(subjectRoot);
        criteria.where(criteriaBuilder.equal(subjectRoot.get("subjectName"), subj));
        Transaction transaction = session.beginTransaction();
        Subject subject = null;
        try {
             subject = entityManager.createQuery(criteria).getSingleResult();
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
