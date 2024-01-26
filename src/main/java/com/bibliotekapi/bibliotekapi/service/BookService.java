package com.bibliotekapi.bibliotekapi.service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bibliotekapi.bibliotekapi.model.Book;
import com.google.gson.Gson;

@Service
public class BookService {
    
    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        try (Reader reader = new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("static/mockBooks.json")
        )) {

            Book[] bookArray = new Gson().fromJson(reader, Book[].class);
            bookList.addAll(Arrays.asList(bookArray));

        } catch (Exception e) {
            System.out.println("NO!");;
        }
    }

    public Book getBook(String isbn) {
        
        return bookList.stream()
        .filter(book -> isbn.equals(book.getIsbn()))
        .findFirst()
        .orElse(null);
    }

    public List<Book> getBooks() {
        
        return bookList;
    }

    public void addBook(Book newBook) {
        
        bookList.add(newBook);

    }

    public void loanBook(Book loanBook) {
        
        Optional<Book> optionalBook = bookList.stream()
        .filter(book -> loanBook.getIsbn().equals(book.getIsbn()))
        .findFirst();
        
        if (optionalBook.isPresent()) {

            Book book = optionalBook.get();
            
            if (book.isAvailability()) {
                book.setAvailability(false);
                System.out.println("Success!" + book.isAvailability());
            } else {
                book.setAvailability(true);
            }
        }
        
        
    }
}
