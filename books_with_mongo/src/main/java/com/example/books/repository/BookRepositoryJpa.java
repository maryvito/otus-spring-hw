package com.example.books.repository;

import com.example.books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {


    Book saveBook(Book book);

    List<Book> findAll();
}
