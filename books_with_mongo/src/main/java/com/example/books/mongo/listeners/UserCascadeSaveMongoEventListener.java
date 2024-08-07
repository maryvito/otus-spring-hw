package com.example.books.mongo.listeners;

import com.example.books.mongo.domain.Author;
import com.example.books.mongo.domain.Book;
import com.example.books.mongo.repository.AuthorMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCascadeSaveMongoEventListener extends AbstractMongoEventListener<Book> {

    private final AuthorMongoRepository authorMongoRepository;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        super.onBeforeConvert(event);
        Object source = event.getSource();
        if ((source instanceof Book) && ((Book) source).getAuthor() != null) {
            authorMongoRepository.save(((Book) source).getAuthor());
        }
    }






}
