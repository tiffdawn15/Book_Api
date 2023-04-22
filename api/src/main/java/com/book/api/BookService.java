package com.book.api;


import com.book.api.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book().id(1)
                .author("Anne Rice")
                .title("Interview with the Vampire"));
        bookList.add(new Book().id(2)
                .author("J.K. Rowling")
                .title("Harry Potter and the Sorcerer's Stone"));


        return bookList;
    }
}