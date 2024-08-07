package com.example.bookssecurity.repository;



import com.example.bookssecurity.domain.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookRepositoryJpa {


    Book saveBook(Book book);
    List<Book> findAll();
}
