package de.antonlammert.todoservice.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Collections;

//indicates that the class declares beans
@Configuration
public class MongoDBConfig {

    //injects the value of the "spring.data.mongodb.database" property in the application.properties into the variable dbName
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.username}")
    private String  userName;

    @Value("${spring.data.mongodb.password}")
    private String  password;

    //creates a MongoClient Bean
    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient(new ServerAddress(mongoHost,mongoPort),
                Collections.singletonList(
                        MongoCredential.createCredential(userName, dbName, password.toCharArray())
                )
        );
    }

    //uses the MongoClient bean and creates a MongoTemplate
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new SimpleMongoDbFactory(mongo(),dbName));
    }
}