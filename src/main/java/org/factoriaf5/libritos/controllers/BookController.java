package org.factoriaf5.libritos.controllers;
import org.factoriaf5.libritos.models.Book;
import org.factoriaf5.libritos.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping("/books")
    String listBooks(Model model) {
        List<Book> books = (List<Book>) bookService.allBooks();
        model.addAttribute("title", "Book list");
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("/new")
    String newBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("title", "Create new book");
        return "books/edit";
    }

    @GetMapping("/edit")
    String editBook(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("title", "Create new book");
        return "books/edit";
    }

    @PostMapping("/new")
    String addBook (@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/books";
    }

}
