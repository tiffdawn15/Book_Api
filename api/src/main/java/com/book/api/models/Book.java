package com.book.api.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document()
public class Book {
    @Indexed
    private String id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @Indexed(unique = true)
    private String title;
    private String author;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book id(String id) {
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

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Book updatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }
}