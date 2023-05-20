package com.book.api;

import com.book.api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "api/books")
public class BookApi {
    @Autowired
    private BookService bookService;

    @GetMapping("/v1")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/v1")
    public Book addBook() {
        return bookService.addBook();
    }

    @PutMapping("/v1")
    public Book editBook(Book book) {
        return bookService.editBook(book);
    }

    @DeleteMapping("/v1/{id}")
    public boolean deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

}