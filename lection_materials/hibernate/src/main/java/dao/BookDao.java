package dao;

import model.Book;

import java.util.List;

/**
 * Created by eugen on 10/29/17.
 */
public interface BookDao {

    List<Book> getAllBooks();

    Integer insert(Book book);

    Book findBookById(Integer id);

    List<Book> findBooksByName(String bookName);

    List<Book> findBooksByGenre(String genre);

    List<Book> getBooksByNameLike(String wildcard);

//    List<Book> getBooksByNameLike(String wildcard);

//    List<Book> getBookByGenre(String authorName);

}
