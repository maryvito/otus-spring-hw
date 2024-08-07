package com.example.books.service;

import com.example.books.dao.BookDao;
import com.example.books.dao.BookDaoImpl;
import com.example.books.domain.Book;
import com.example.books.repository.BookRepository;
import com.example.books.repository.BookRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {



    private final BookRepository repository;


    public Optional<Book> getById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public void deleteById(Integer id){
        repository.deleteById(id);
    }



}
