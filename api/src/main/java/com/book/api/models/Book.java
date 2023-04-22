package com.book.api.models;

import java.time.LocalDateTime;

public class Book {

    private int id;
    private LocalDateTime createdDate;
    private String title;
    private String author;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book id(int id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Book createdDate(LocalDateTime createdDate) {
        this.createdDate = LocalDateTime.now();
        return this;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book author(String author) {
        this.author = author;
        return this;
    }


}