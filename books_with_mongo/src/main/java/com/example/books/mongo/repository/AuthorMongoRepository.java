package com.example.books.mongo.repository;

import com.example.books.mongo.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorMongoRepository extends MongoRepository<Author, String> {
}
