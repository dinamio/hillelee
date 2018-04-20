package service;

import db.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BookAdder {
    private List<Book> bookList;

    public boolean addBook(Book book) {
        Objects.requireNonNull(book);
        if (bookList == null) {
            bookList = new LinkedList<>();
        }
        return bookList.add(book);
    }

    public List<Book> viewBooks() {
        return Collections.unmodifiableList(bookList);
    }

    public boolean deleteBook(Book book) {
        Objects.requireNonNull(book);
        return bookList.remove(book);
    }
}
