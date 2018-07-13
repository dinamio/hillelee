package com.hillel.servlet.entity;

import javax.persistence.*;

/**
 * Created by eugen on 5/11/18.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String name;


    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    public Book() {
    }

    public Book(Integer id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author.getSurname() + '\'' +
                '}';
    }
}
