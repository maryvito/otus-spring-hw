package com.example.books.dao;

import com.example.books.domain.Author;
import com.example.books.domain.Book;
import com.example.books.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Repository("jdbcBookDao")
public class BookDaoImpl implements BookDao{

    private final JdbcClient jdbcClient;
    private final NamedParameterJdbcOperations jdbc;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public BookDaoImpl(JdbcClient jdbcClient, NamedParameterJdbcOperations jdbc, DataSource dataSource) {
        this.jdbcClient = jdbcClient;
        this.jdbc = jdbc;
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("books").usingGeneratedKeyColumns("id");
    }

    @Override
    public Integer insert(Book book) {

        Map<String, Object> parametrs = Map.of("name", book.getName(),
                "author_id", book.getAuthor().getId(),
                "genre_id", book.getGenre().getId());

        Number id = simpleJdbcInsert.executeAndReturnKey(parametrs);

        return (Integer) id;

    }

    @Override
    public Book getById(Integer id) {
        return jdbc.queryForObject("select books.*, authors.*, genres.* from books" +
                        " left join authors on books.author_id = authors.id" +
                        " left join genres on genres.id = books.genre_id" +
                        " where books.id = :id",
                Map.of("id", id),
                new BookRowMapper());
    }

    @Override
    public void deleteById(Integer id) {
        jdbc.update("delete from books where id = :id", Map.of("id", id));
    }

    @Override
    public void update(Book book) {
        jdbc.update("update books " +
                "set name = :name, " +
                "    author_id = :authorId," +
                "    genre_id = :genreId" +
                " where id = :id",
                Map.of("id", book.getId(),
                       "name", book.getName(),
                       "authorId", book.getAuthor().getId(),
                        "genreId", book.getGenre().getId()));
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select books.*, authors.*, genres.* from books" +
                        " left join authors on books.author_id = authors.id" +
                        " left join genres on genres.id = books.genre_id",
                new BookRowMapper());
    }

    private class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer id = rs.getInt("books.id");
            String name = rs.getString("books.name");
            Integer authorId = rs.getInt("books.author_id");
            Integer genreId = rs.getInt("books.genre_id");

            String authorName = rs.getString("authors.name");
            String genreName = rs.getString("genres.name");

            return Book.builder()
                    .id(id)
                    .name(name)
                    .author(Author.builder()
                            .id(authorId)
                            .name(authorName)
                            .build())
                    .genre(Genre.builder()
                            .id(genreId)
                            .name(genreName)
                            .build())
                    .build();
        }
    }
}
