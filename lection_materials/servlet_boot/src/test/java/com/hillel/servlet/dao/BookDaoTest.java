package com.hillel.servlet.dao;

import com.hillel.servlet.ServletApplicationTests;
import com.hillel.servlet.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugen on 7/20/18.
 */
@DataJpaTest
public class BookDaoTest extends ServletApplicationTests {

    @Autowired
    BookDao bookDao;

    @Before
    public void setup() {
        System.out.println("We are in setup");
    }

    @Test
    public void shouldFindBooksByNameLike () {
        bookDao.save(new Book("Game of thrones 2", null));
        bookDao.save(new Book("Game of thrones 3", null));
        bookDao.save(new Book("Morning Magic", null));

        List<Book> booksByNameLike = bookDao.findBooksByNameLike("%ame of%");

        assertEquals(booksByNameLike.size(), 2);
    }
}
