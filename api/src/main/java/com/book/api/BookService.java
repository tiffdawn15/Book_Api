package com.book.api;

import com.book.api.models.Book;
import com.book.api.resources.OperationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public OperationResult<List<Book>> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            books = bookRepository.findAll();
        } catch (Exception e) {
            LOG.error(e.toString());
        }

        OperationResult result = new OperationResult();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (books.isEmpty()) {
            result.setHttpStatus(HttpStatus.NO_CONTENT);
        } else {
            status = HttpStatus.OK;
            result.result(books)
                    .worked(true);
        }
        return result.httpStatus(status);
    }

    /**
     * Add a new book to the book db
     *
     * @param book {@link Book}
     * @return success boolean
     */
    public OperationResult<Boolean> addBook(Book book) {
        OperationResult<Boolean> result = new OperationResult<>();
        boolean success = false;
        book.createdDate(LocalDateTime.now());
        try {
            bookRepository.save(book);
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to save new book. %s", book.getTitle()), e);
        }

        return result.result(true)
                .worked(true)
                .httpStatus(HttpStatus.OK);
    }

    /**
     * Update a book's data
     *
     * @param book {@link Book}
     * @param id
     * @return
     */
    public OperationResult<Book> editBook(Book book, String id) {
        OperationResult<Book> result = new OperationResult<>();
        // Attempt to edit book in Mongodb
        Book savedBook = new Book();
        book.updatedDate(LocalDateTime.now());

        // TODO: Check that the created date isn't being set to null
        try {
            savedBook = bookRepository.save(book);
        } catch (Exception e) {
            LOG.error(String.format("Failed to edit book in Mongodb. Id: %s"), book.getId());
            return result.worked(false)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result.result(savedBook)
                .httpStatus(HttpStatus.OK)
                .worked(true);
    }

    /**
     * Delete book based by id
     *
     * @param id Book's id
     * @return success boolean
     */
    public OperationResult<Boolean> deleteBook(String id) {
        OperationResult<Boolean> result = new OperationResult<>();
        Boolean success = false;
        // Attempt to edit book in Mongodb
        try {
            bookRepository.deleteById(id);
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to delete book in Mongodb. Id: %x"), id);
            return result.httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .worked(false);
        }
        return result.result(success)
                .worked(true)
                .httpStatus(HttpStatus.OK);
    }
}