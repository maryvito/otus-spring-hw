package com.example.bookssecurity.rest;

import com.example.bookssecurity.domain.Book;
import com.example.bookssecurity.repository.BookRepository;
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
