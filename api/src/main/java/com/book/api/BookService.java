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
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book().id(1)
                .author("Anne Rice")
                .title("Interview with the Vampire"));
        bookList.add(new Book().id(2)
                .author("J.K. Rowling")
                .title("Harry Potter and the Sorcerer's Stone"));

        List<Book> books = bookRepository.findAll();

        return bookList;
    }

    public Book addBook() {

        Book book = new Book().title("Dune")
                .author("Frank Herbert")
                .createdDate(LocalDateTime.now());

        return bookRepository.save(book);
    }

    public Book editBook(Book book) {
        // Attempt to edit book in MongoDB
        try {
            bookRepository.findById(String.valueOf(book.getId()));
        } catch (Exception e) {
            LOG.error(String.format("Failed to edit book in MongoDB. Id: %s"), book.getId());
        }
        return book;
    }

    public boolean deleteBook(int id) {
        boolean success = false;
        // Attempt to edit book in MongoDB
        try {
            bookRepository.deleteById(String.valueOf(id));
            success = true;
        } catch (Exception e) {
            LOG.error(String.format("Failed to delete book in MongoDB. Id: %s"), id);
        }
        return success;
    }

}