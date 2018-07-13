package com.hillel.servlet.service;

import com.hillel.servlet.dao.BookDao;
import com.hillel.servlet.entity.Book;
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
        System.out.println("Count of books: " + bookDao.countBooks() + " " + bookDao.count());
        return (List<Book>) bookDao.findBooksByNameLike("%sht%");
    }

    public void addBook(Book book) {
        bookDao.save(book);
    }

    public void deleteBook(Integer id) {
        bookDao.deleteById(id);
    }
}
