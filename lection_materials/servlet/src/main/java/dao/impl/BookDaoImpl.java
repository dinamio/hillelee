package dao.impl;

import dao.BookDao;
import entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
@Repository
public class BookDaoImpl implements BookDao {

    private static Logger logger = Logger.getLogger(BookDao.class);

    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + Book.class.getName());
        return query.list();
    }

    @Override
    public void insert(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(book);
    }

    @Override
    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.find(Book.class, id);
        session.remove(book);
        transaction.commit();
    }
}
