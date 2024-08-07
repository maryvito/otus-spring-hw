package com.example.books_web.repository;


import com.example.books_web.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryJpa {
}
