package borysov.dao.impl;

import borysov.dao.UserDao;
import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.service.UserService;
import borysov.utility.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.sql.SQLException;

@Component
@Repository
@Qualifier("hibernate")
public class UserHibernateDaoImpl implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    public User getUserFromDB(String login, String password) throws SQLException, DAOException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = session.createQuery("from User where login=:userLogin and password=:userPass");
        query.setParameter("userLogin", login);
        query.setParameter("userPass", password);
        User user = null;
        try {
            user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException ex) {
            throw new DAOException();
        }

    }

    public void addNewUserToDB(User newUser) {
        LOGGER.info("addNewUserToDB, UserHibernateDaoImpl");
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        session.flush();
        transaction.commit();
    }
}
