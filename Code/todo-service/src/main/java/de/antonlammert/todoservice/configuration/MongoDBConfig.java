package de.antonlammert.todoservice.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//indicates that the class declares beans
@Configuration
public class MongoDBConfig {

    //injects the value of the "spring.data.mongodb.database" property in the application.properties into the variable dbName
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    //creates a MongoClient Bean
    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient();
    }

    //uses the MongoClient bean and creates a MongoTemplate
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), dbName);
    }
}