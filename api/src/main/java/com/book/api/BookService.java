package com.book.api;

import com.book.api.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // TODO: Operation Results
    @Autowired
    BookRepository bookRepository;
    Logger LOG = LoggerFactory.getLogger(BookService.class);

    /**
     * Fetch list of books
     *
     * @return List of {@link Book}
     */
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            books = bookRepository.findAll();
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return books;
    }

    /**
     * Add a new book to the book db
     *
     * @param book {@link Book}
     * @return success boolean
     */
    public boolean addBook(Book book) {
        boolean success = false;
        book.createdDate(LocalDateTime.now());
        try {
            bookRepository.save(book);
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to save new book. %s", book.getTitle()), e);
        }

        return success;
    }

    /**
     * Update a book's data
     * @param book {@link Book}
     * @param id
     * @return
     */
    public Book editBook(Book book, String id) {
        // Attempt to edit book in Mongodb
        Book savedBook = new Book();
        book.updatedDate(LocalDateTime.now());

        // TODO: Check that the created date isn't being set to null
        try {
            savedBook = bookRepository.save(book);
        } catch (Exception e) {
            LOG.error(String.format("Failed to edit book in Mongodb. Id: %s"), book.getId());
        }
        return savedBook;
    }

    /**
     * Delete book based by id
     *
     * @param id Book's id
     * @return success boolean
     */
    public boolean deleteBook(String id) {
        boolean success = false;
        // Attempt to edit book in Mongodb
        try {
            bookRepository.deleteById(id);
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to delete book in Mongodb. Id: %x"), id);
        }
        return success;
    }
}