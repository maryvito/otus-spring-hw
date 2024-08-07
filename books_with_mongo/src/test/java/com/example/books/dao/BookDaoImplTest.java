package com.example.books.dao;

import com.example.books.domain.Author;
import com.example.books.domain.Book;
import com.example.books.domain.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(BookDaoImpl.class)
class BookDaoImplTest {

    public static final String TEST_BOOK = "testBook";
    public static final int AUTHOR_ID = 1;
    public static final int GENRE_ID = 1;
    @Autowired
    BookDaoImpl bookDao;

    @Test
    void insert() {
        Book insertingBook = Book.builder()
                .name(TEST_BOOK)
                .author(Author.builder()
                        .id(AUTHOR_ID)
                        .build())
                .genre(Genre.builder()
                        .id(GENRE_ID)
                        .build())
                .build();

        Integer bookId = bookDao.insert(insertingBook);
        Book insertedBook = bookDao.getById(bookId);
        insertingBook.setId(bookId);

        assertThat(insertedBook).isEqualTo(insertingBook);

    }

}