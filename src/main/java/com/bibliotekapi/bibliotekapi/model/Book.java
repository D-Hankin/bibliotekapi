package com.bibliotekapi.bibliotekapi.model;

public class Book {
    private String title;
    private String author;
    private String publication_date;
    private String genre;
    private String isbn;
    private boolean availability;
    
    public Book(String title, String author, String publication_date, String genre, String isbn, boolean availability) {
        this.title = title;
        this.author = author;
        this.publication_date = publication_date;
        this.genre = genre;
        this.isbn = isbn;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publication_date;
    }

    public void setPublicationDate(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    
}
