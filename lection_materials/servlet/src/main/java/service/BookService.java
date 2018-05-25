package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getBooks() {
        return bookDao.getAllBooks();
    }

    public void addBook(Book book) {
        bookDao.insert(book);
    }

    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }
}
