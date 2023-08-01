package com.book.api;

import com.book.api.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    Logger LOG = LoggerFactory.getLogger(BookService.class);

    public List<Book> getBooks() {
        LOG.warn("I have made it to the book service class");
        List<Book> books = new ArrayList<>();
        try {
            books = bookRepository.findAll();
        } catch (Exception e) {
            LOG.error(e.toString());
        }

        return books;
    }

    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    public Book editBook(Book book, String id) {
        // Attempt to edit book in Mongodb
        try {
            bookRepository.findById(String.valueOf(id));
        } catch (Exception e) {
            LOG.error(String.format("Failed to edit book in Mongodb. Id: %x"), book.getId());
        }
        return book;
    }

    public boolean deleteBook(String id) {
        boolean success = false;
        // Attempt to edit book in Mongodb
        try {
            bookRepository.deleteById(String.valueOf(id));
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to delete book in Mongodb. Id: %x"), id);
        }
        return success;
    }
}