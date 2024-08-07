package com.example.books_web.repository;



import com.example.books_web.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepositoryJpa {

    Optional<Comment> findById(Integer id);

    Comment save(Comment book);

    void deleteById(Integer id);


    List<Comment> findAll();
}
