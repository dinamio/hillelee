package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getBooks() {
        return bookDao.getAllBooks();
    }

    public void addBook(Book book) {
        bookDao.insert(book);
    }
}
