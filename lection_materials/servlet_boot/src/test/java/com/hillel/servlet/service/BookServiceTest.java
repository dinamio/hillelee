package com.hillel.servlet.service;

import com.hillel.servlet.dao.BookDao;
import com.hillel.servlet.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by eugen on 7/20/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @MockBean
    BookDao bookDao;

    @Test
    public void shouldGetAllBooks() {

        when(bookDao.findBooksByNameLike(anyString())).thenReturn(asList(new Book("Game of thrones", null)));

        List<Book> books = bookService.getBooks();

        assertEquals(1, books.size());
        Book book = books.get(0);
        assertEquals("Game of thrones", book.getName());

    }

}
