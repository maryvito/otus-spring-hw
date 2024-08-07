package com.example.books.repository;

import com.example.books.domain.Author;
import com.example.books.domain.Book;
import com.example.books.domain.Comment;
import com.example.books.domain.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с книгами должен ")
@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
class BookRepositoryJpaImplTest {

    public static final int EVGENII_ONEGIN_BOOK_ID = 1;
    public static final int EVGENII_ONEGIN_NUMBER_COMMENTS = 5;
    public static final int EVG_ONEG_AUTHOR_ID = 1;
    public static final int GENRE_ROMAN_ID = 1;
    public static final String COMMENT_TEXT_1 = "test-1";
    public static final String COMMENT_TEXT_2 = "test-2";
    public static final String BOOK_NAME = "Золотая рыбка";
    public static final int COMMENT_SIZE = 2;
    public static final int EXPECTED_BOOK_SIZE = 3;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("корректно доставать книгу и всю информацию, связанную с ней по id")
    @Test
    void findById() {
        Optional<Book> maybeBook = bookRepository.findById(EVGENII_ONEGIN_BOOK_ID);

        assertThat(maybeBook).isPresent().get()
                .matches(book -> book.getComments() != null
                        && book.getComments().size() == EVGENII_ONEGIN_NUMBER_COMMENTS)
                .matches(book -> book.getAuthor() != null && book.getAuthor().getId() == EVG_ONEG_AUTHOR_ID);
    }

    @DisplayName(" корректно сохранять книгу и всю информацию о ней")
    @Test
    void shouldSaveAllBookINfo() {
        Author author = Author.builder().id(EVG_ONEG_AUTHOR_ID).build();
        Genre genre = Genre.builder().id(GENRE_ROMAN_ID).build();
        List<Comment> comments = List.of(Comment.builder().text(COMMENT_TEXT_1).build(),
                Comment.builder().text(COMMENT_TEXT_2).build());

        Book book = Book.builder()
                .name(BOOK_NAME)
                .author(author)
                .genre(genre)
                .comments(comments)
                .build();

        bookRepository.save(book);
        assertThat(book.getId()).isNotNull().isGreaterThan(0);

        Book actualBook = em.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull()
                .matches(actBook -> actBook.getGenre() != null
                        && actBook.getGenre().getId().equals(GENRE_ROMAN_ID))
                .matches(actBook -> actBook.getComments() != null
                        && actBook.getComments().size() == COMMENT_SIZE);
    }

    @DisplayName(" удалять книгу и все комментарии о ней по id")
    @Test
    void deleteById() {
        bookRepository.deleteById(EVGENII_ONEGIN_BOOK_ID);

        Book book = em.find(Book.class, EVGENII_ONEGIN_BOOK_ID);
        List<Comment> comments = commentRepository.findAllByBookId(EVGENII_ONEGIN_BOOK_ID);

        assertThat(book).isNull();
        assertThat(comments).isEmpty();
    }

    @DisplayName(" загружать список всех книг со всей информацией о них")
    @Test
    void findAll() {

        var books = bookRepository.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_BOOK_SIZE)
                .allMatch(b -> b.getAuthor() != null)
                .allMatch(b -> b.getComments() != null && b.getComments().size() > 0);
    }
}