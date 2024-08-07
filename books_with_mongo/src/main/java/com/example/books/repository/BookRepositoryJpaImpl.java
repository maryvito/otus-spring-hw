package com.example.books.repository;

import com.example.books.domain.Book;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa{

    @PersistenceContext
    EntityManager em;


    @Override
    public Book saveBook(Book book) {
        if(book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }


    @Override
    public List<Book> findAll() {
        EntityGraph<?> entityGraph = em.getEntityGraph("author_genre_graph");

        return em.createQuery("select b from Book b", Book.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }
}
