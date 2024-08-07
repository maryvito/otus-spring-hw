package com.example.books_web.domain;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode(exclude = {"author", "genre", "comments"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer bookId;

    private String text;
}
