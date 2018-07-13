package com.hillel.servlet.dao;

import com.hillel.servlet.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

    List<Book> findBooksByNameLike(String name);

    @Query(value = "select count(*) from book", nativeQuery = true)
    Integer countBooks();
}
