package dao;

import entity.Book;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
public interface BookDao {

    List<Book> getAllBooks();

    void insert(Book book);
}
