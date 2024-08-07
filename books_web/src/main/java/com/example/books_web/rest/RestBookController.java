package com.example.books_web.rest;

import com.example.books_web.domain.Book;
import com.example.books_web.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestBookController {

    private final BookRepository bookRepository;

    @GetMapping("/api/books")
    public List<Book> getBooks(){
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
