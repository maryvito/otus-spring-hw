package com.example.bookssecurity.repository;

import com.example.bookssecurity.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CommentRepositoryJpa {

    List<Comment> findAllByBookId(Integer bookId);
}
