package entity;

import java.util.List;

/**
 * Created by eugen on 5/18/18.
 */
public class Author {

    List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "bookList=" + bookList +
                '}';
    }
}
