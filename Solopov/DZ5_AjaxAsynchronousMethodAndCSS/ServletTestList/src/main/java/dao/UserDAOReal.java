package dao;

import model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class UserDAOReal extends EntityDAO<User, Integer> {


    public UserDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findByLogin(String login) {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        User result = (User) criteria.uniqueResult();
        session.flush();
        transaction.commit();
        return result;
    }
}