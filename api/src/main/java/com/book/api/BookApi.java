package com.book.api;

import com.book.api.models.Book;
import com.book.api.resources.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/books")
public class BookApi {
    @Autowired
    private BookService bookService;

    @GetMapping("/v1")
    public OperationResult<List<Book>> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/v1")
    public OperationResult<Boolean> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/v1/{id}")
    public OperationResult<Book> editBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.editBook(book, id);
    }

    @DeleteMapping("/v1/{id}")
    public OperationResult<Boolean> deleteBook(@PathVariable String id) {
        return bookService.deleteBook(id);
    }

}