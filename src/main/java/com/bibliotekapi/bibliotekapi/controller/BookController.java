package com.bibliotekapi.bibliotekapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotekapi.bibliotekapi.model.Book;
import com.bibliotekapi.bibliotekapi.service.BookService;

@RestController
public class BookController {
 
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        System.out.println("Here");
    }

    @GetMapping("/book-list")
    public List<Book> getBooks() {
        
        return bookService.getBooks();
    }

    @GetMapping("/book")
    public Book getBook(String isbn) {
        return bookService.getBook(isbn);
    }

    @PostMapping("/add-book")
    public List<Book> addBook(@RequestBody Book newBook) {

        bookService.addBook(newBook);
        System.out.println("newBook");

        return bookService.getBooks();
    }
    
}
