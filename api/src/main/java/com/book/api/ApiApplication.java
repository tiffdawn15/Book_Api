package com.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication()
@EnableMongoRepositories( )
public class ApiApplication implements ErrorController {

	@Autowired
	BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@RequestMapping( "/error")
	public String error() { return "forward: index.html";}

}
