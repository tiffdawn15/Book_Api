package com.book.api;

import com.book.api.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

   @Autowired
   BookRepository bookRepository;

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book().id(1)
                .author("Anne Rice")
                .title("Interview with the Vampire"));
        bookList.add(new Book().id(2)
                .author("J.K. Rowling")
                .title("Harry Potter and the Sorcerer's Stone"));


        return bookList;
    }

    public Book addBook() {

        Book book = new Book().title("Dune")
                .author("Frank Herbert")
                .createdDate(LocalDateTime.now());

        return bookRepository.save(book);
    }

}