package com.example.bookssecurity.repository;



import com.example.bookssecurity.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryJpa {

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Book getById(Integer id);
}
