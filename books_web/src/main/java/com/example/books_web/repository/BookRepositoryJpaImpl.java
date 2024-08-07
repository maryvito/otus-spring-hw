package com.example.books_web.repository;


import com.example.books_web.domain.Book;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryJpaImpl implements BookRepositoryJpa {

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
