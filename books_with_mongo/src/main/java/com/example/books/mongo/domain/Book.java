package com.example.books.mongo.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("books")
public class Book {

    @Id
    private String id;
    private String name;
    @DBRef
    private Author author;

    private Genre genre;


}
