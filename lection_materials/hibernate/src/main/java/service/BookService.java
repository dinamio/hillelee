package service;

import dao.BookDao;
import dao.impl.HibernateBookDao;
import model.Book;

import java.util.List;

/**
 * Created by eugen on 11/6/17.
 */
public class BookService {

    private BookDao bookDao;

    public BookService() {
        bookDao = new HibernateBookDao();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = bookDao.getAllBooks();
        System.out.println(allBooks);
        return allBooks;
    }

    public List<Book> getBooksByName(String bookName) {
        return bookDao.findBooksByName(bookName);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookDao.findBooksByGenre(genre);
    }

    public List<Book> getBooksByNameLike(String wildcard) {
        return bookDao.getBooksByNameLike(wildcard);
    }

    /*public List<Book> getBooksByNameLike(String name) {
        return bookDao.getBooksByNameLike(name);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookDao.getBookByGenre(genre);
    }
*/
}
