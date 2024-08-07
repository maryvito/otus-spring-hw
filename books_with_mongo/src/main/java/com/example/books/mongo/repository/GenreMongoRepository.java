package com.example.books.mongo.repository;

import com.example.books.mongo.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreMongoRepository extends MongoRepository<Genre, String> {
}
