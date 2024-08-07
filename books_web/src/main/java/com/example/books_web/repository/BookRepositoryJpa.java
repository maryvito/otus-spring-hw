package com.example.books_web.repository;



import com.example.books_web.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookRepositoryJpa {


    Book saveBook(Book book);
    List<Book> findAll();
}
