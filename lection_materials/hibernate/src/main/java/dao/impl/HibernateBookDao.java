package dao.impl;

import config.HibernateUtil;
import dao.BookDao;
import model.Book;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

/**
 * Created by eugen on 11/2/17.
 */
public class HibernateBookDao implements BookDao {
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> list = session.createQuery("from model.Book ").list();
        session.close();

        return list;
    }

    public Integer insert(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(book);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public Book findBookById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Book book = (Book) session.get(Book.class, id);
        session.close();
        return book;
    }

    public List<Book> findBooksByName(String bookName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query book_name = session.createQuery("from Book b where b.genre.name=:book_name and genre is null");
        book_name = book_name.setString("book_name", bookName);
        List<Book> books = book_name.list();
        return books;
    }

    public List<Book> findBooksByGenre(String genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        Criteria genre1 = criteria.createCriteria("genre");
        genre1.add(Restrictions.eq("name",genre));
        return criteria.list();
    }

    public List<Book> getBooksByNameLike(String wildcard) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        wildcard = "%"+wildcard +"%";
        criteria.add(Restrictions.like("name",wildcard));
        return criteria.list();
    }
}



 /*  public List<Book> getBooksByNameLike(String wildcard) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        wildcard = "%"+wildcard+"%";
        Criteria criteria = session.createCriteria(Book.class);
        criteria.add(Restrictions.like("name", wildcard));
        criteria.setMaxResults(3);
        List<Book> list = criteria.list();
        session.close();
        return list;
    }

    public List<Book> getBookByGenre(String genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        criteria.createCriteria("genre").add(Restrictions.eq("name",genre));
        List<Book> list = criteria.list();
        session.close();
        return list;
    }*/