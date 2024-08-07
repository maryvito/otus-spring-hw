package com.example.books.mongo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("genres")
public class Genre {
    @Id
    private String id;
    private String name;
}
