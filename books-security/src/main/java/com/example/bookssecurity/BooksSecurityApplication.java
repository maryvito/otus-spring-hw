package com.example.bookssecurity;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class BooksSecurityApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(BooksSecurityApplication.class, args);
        Console.main(args);

    }

}
