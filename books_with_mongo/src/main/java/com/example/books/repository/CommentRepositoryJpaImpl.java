package com.example.books.repository;

import com.example.books.domain.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryJpaImpl implements CommentRepositoryJpa{

    @PersistenceContext
    EntityManager em;

    @Override
    public Optional<Comment> findById(Integer id) {
        return Optional.ofNullable(em.find(Comment.class, id));
    }

    @Override
    public Comment save(Comment comment) {
       if(comment.getId() == null) {
           em.persist(comment);
           return comment;
       } else {
           return em.merge(comment);
       }
    }

    @Override
    public void deleteById(Integer id) {
        em.createQuery("delete from Comment c where c.id = :id", Comment.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }
}
