package borysov.dao.impl;

import borysov.dao.UserDao;
import borysov.entity.User;
import borysov.exception.DAOException;
import borysov.service.UserService;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final Session session;

    @Autowired
    public UserHibernateDaoImpl(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public User getUserFromDB(String login, String password) throws SQLException, DAOException {

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
        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        session.flush();
        transaction.commit();
    }
}
