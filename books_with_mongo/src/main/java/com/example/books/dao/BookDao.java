package com.example.books.dao;

import com.example.books.domain.Book;

import java.util.List;

public interface BookDao {

    Integer insert(Book book);

    Book getById(Integer id);

    void deleteById(Integer id);

    void update(Book book);

    List<Book> getAll();
}
