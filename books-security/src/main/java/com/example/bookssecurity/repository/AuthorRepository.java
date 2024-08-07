package com.example.bookssecurity.repository;


import com.example.bookssecurity.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
