package com.example.books.mongo.repository;


import com.example.books.mongo.domain.Author;
import com.example.books.mongo.domain.Book;
import com.example.books.mongo.domain.Genre;
import com.example.books.mongo.listeners.UserCascadeSaveMongoEventListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
@Import(UserCascadeSaveMongoEventListener.class)
class BookMongoRepositoryTest {

    @Autowired
    private BookMongoRepository bookMongoRepository;

    @DisplayName(" корректно сохранить книгу с отсутсвующим в БД автором")
    @Test
    void checkCreateBookWithBookInfo(){
        Book book = Book.builder()
                .name("test")
                .author(Author.builder().name("test").build())
                .genre(Genre.builder()
                        .name("test")
                        .build())
                .build();
        String id = bookMongoRepository.save(book).getId();

        Optional<Book> expectedBook = bookMongoRepository.findById(id);

        assertThat(expectedBook).get()
                .matches(eb -> eb.getAuthor().getName().equals(book.getAuthor().getName()))
                .matches(eb -> eb.getName().equals(book.getName()))
                .matches(eb -> eb.getGenre().getName().equals(book.getGenre().getName()));
    }






}