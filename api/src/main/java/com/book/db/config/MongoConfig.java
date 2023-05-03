package com.book.db.config;

import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

//     @Value("$spring.data.mongodb.uri")
//     private String mongoUri;
//
//     @Value("$spring.data.mongodb.database")
//     private String mongoDatabase;
//     private MongoTemplate mongoTemplate;
//
//
     MongoClientSettings mongoClientSettings = MongoClientSettings.builder( ).build();
//
     @Bean
     public MongoDatabaseFactory mongoDatabaseFactory(){
          return new SimpleMongoClientDatabaseFactory("mongo://localhost:27017/");
     }

     @Override
     protected String getDatabaseName() {
          return null;
     }
////
////     @Bean
////     public MongoOperations mongoOperations() {
//////          MongoDatabaseFactory databaseFactory = new MongoDatabaseFactory().getMongoDatabase()
////       return   mongoTemplate = new MongoTemplate( mongoDatabaseFactory() );
////
////     }
//
//
//     @Override
//     protected String getDatabaseName() {
//          return "books";
//     }
//
//
//     @Override
//     public Collection getMappingBasePackages() {
//          return Collections.singleton("com.baeldung");
//     }
//


}