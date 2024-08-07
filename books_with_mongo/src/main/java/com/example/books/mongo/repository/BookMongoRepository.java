package com.example.books.mongo.repository;

import com.example.books.mongo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMongoRepository extends MongoRepository<Book, String> {
}
