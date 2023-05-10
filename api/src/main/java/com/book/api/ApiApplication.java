package com.book.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication()
@EnableMongoRepositories( )
public class ApiApplication implements ErrorController {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@RequestMapping( "/error")
	public String error() { return "forward: index.html";}

//	/*
//	 * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
//	 */
//	public @Bean MongoClient mongoClient() {
//		return MongoClients.create("mongodb://localhost:27017");
//	}
//
//	MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");
//    mongoOps.insert(new Person("Joe", 34));
//
//    log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));
//
//    mongoOps.dropCollection("person");
}
