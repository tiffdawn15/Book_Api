package com.book.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApi {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}