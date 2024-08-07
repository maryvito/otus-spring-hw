package com.example.books;


import com.example.books.mongo.domain.Author;
import com.example.books.mongo.domain.Book;
import com.example.books.mongo.repository.BookMongoRepository;
import com.example.books.repository.BookRepositoryJpa;
import com.example.books.service.BookService;
import com.github.cloudyrock.spring.v5.EnableMongock;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@EnableMongock
@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(BooksApplication.class, args);

        BookMongoRepository bookMongoRepository = context.getBean(BookMongoRepository.class);

        //Console.main(args);


    }


}
