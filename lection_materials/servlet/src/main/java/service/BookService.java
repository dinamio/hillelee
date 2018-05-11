package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
public class BookService {

    private BookDao bookDao = new BookDaoImpl();

    public List<Book> getBooks() {
        return bookDao.getAllBooks();
    }

    public void addBook(Book book) {
        bookDao.insert(book);
    }
}
