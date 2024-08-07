package com.example.books.shell;

import com.example.books.domain.Book;
import com.example.books.domain.Comment;
import com.example.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
public class BookCommands {


    private final BookService bookService;

    public String userName;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login(@ShellOption(defaultValue = "AnyUser") String login){
        this.userName = login;
        return String.format("Добро пожаловать %s", userName);
    }

    public Availability isTestMethodAvailable(){
        return userName == null ? Availability.unavailable("Сначала залогиньтесь") : Availability.available();
    }


    @ShellMethod(value = "getById", key = {"g", "get"})
    public String getById(@ShellOption(defaultValue = "1") String id){
        Optional<Book> book = bookService.getById(Integer.valueOf(id));
        List<Comment> comments = book.get().getComments();
        return book.toString();
    }
}
