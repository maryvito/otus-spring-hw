package com.example.books.mongo.mongock.changelog;

import com.example.books.mongo.domain.Author;
import com.example.books.mongo.domain.Book;
import com.example.books.mongo.domain.Genre;
import com.example.books.mongo.repository.AuthorMongoRepository;
import com.example.books.mongo.repository.BookMongoRepository;
import com.example.books.mongo.repository.GenreMongoRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@ChangeLog(order = "001")
public class DatabaseChangelog {


    @ChangeSet(order = "001", id = "dropDb", author = "mvv", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertBooks", author = "mvv")
    public void insertBooks(AuthorMongoRepository authorMongoRepository,
                            BookMongoRepository bookMongoRepository,
                            GenreMongoRepository genreMongoRepository) {

        Author pushkin = Author.builder()
                .name("Puskin")
                .build();

        Author kristi = Author.builder()
                .name("Kristi")
                .build();

        pushkin = authorMongoRepository.insert(pushkin);
        kristi = authorMongoRepository.insert(kristi);

        Genre roman = Genre.builder()
                .name("roman")
                .build();
        Genre detectiv = Genre.builder()
                .name("detectiv")
                .build();

        roman = genreMongoRepository.insert(roman);
        detectiv = genreMongoRepository.insert(detectiv);

        Book book1 = Book.builder()
                .name("Evgenii Onegin")
                .author(pushkin)
                .genre(roman)
                .build();

        Book book2 = Book.builder()
                .name("Capitan")
                .author(pushkin)
                .genre(roman)
                .build();

        Book book3 = Book.builder()
                .name("Puaro")
                .author(kristi)
                .genre(detectiv)
                .build();

        bookMongoRepository.insert(List.of(book1, book2, book3));


    }

    /*@ChangeSet(order = "002", id = "insertBooks", author = "mvv")
    public void insertBooks(MongoDatabase db) {
        MongoCollection<Document> booksCollection = db.getCollection("books");
        MongoCollection<Document> authorsCollection = db.getCollection("authors");
        MongoCollection<Document> genresCollection = db.getCollection("genres");

        var pushkin = new Document().append("_id", 1).append("name", "Александр Пушкин");
        var kristi = new Document().append("_id", 2).append("name", "Агата Кристи");
        authorsCollection.insertMany(List.of(pushkin, kristi));

        var roman = new Document().append("_id", 1).append("name", "роман");
        var detectiv = new Document().append("_id", 2).append("name", "детектив");
        genresCollection.insertMany(List.of(roman, detectiv));


        var evgenii_onegin = new Document().append("_id", "1")
                .append("name", "Евгений Онегин")
                .append("author", pushkin)
                .append("genre", roman);

        var capitanskaya_dochka = new Document().append("_id", "2")
                .append("name", "Капитанская дочка")
                .append("author", pushkin)
                .append("genre", roman);

        var erkul_pyaro = new Document().append("_id", "3")
                .append("name", "Эркюль Пуаро")
                .append("author", kristi)
                .append("genre", detectiv);



        booksCollection.insertMany(List.of(evgenii_onegin, capitanskaya_dochka, erkul_pyaro));
    }*/
}
