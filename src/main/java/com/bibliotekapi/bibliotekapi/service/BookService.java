package com.bibliotekapi.bibliotekapi.service;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bibliotekapi.bibliotekapi.model.Book;
import com.google.gson.Gson;

@Service
public class BookService {
    
    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        try (Reader reader = new FileReader("mockData/mockBooks.json")) {

            Book[] bookArray = new Gson().fromJson(reader, Book[].class);
            bookList.addAll(Arrays.asList(bookArray));
            System.out.println(bookList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
