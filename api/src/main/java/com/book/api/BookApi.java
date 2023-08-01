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
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/v1/{id}")
    public Book editBook(@PathVariable String id, Book book) {
        return bookService.editBook(book, id);
    }

    @DeleteMapping("/v1/{id}")
    public boolean deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

}