package com.example.books_web.http;


import com.example.books_web.domain.Book;
import com.example.books_web.repository.AuthorRepository;
import com.example.books_web.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping("/")
    public String getBooks(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam("id") int id, Model model){
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book.orElse(Book.builder().build()));
        model.addAttribute("authors", authorRepository.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String saveBook(Book book,
                           RedirectAttributes attr){
        Book savedBook = bookRepository.saveBook(book);
        attr.addAttribute("id", savedBook.getId());
        return "redirect:/edit";
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam("id") Integer id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createBook(RedirectAttributes attr){
        attr.addFlashAttribute("authors", authorRepository.findAll());
        attr.addAttribute("id", 0);
        return "redirect:/edit";
    }



}
