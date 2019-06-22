package de.antonlammert.todoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//signals the start point of our Spring Boot Application
@SpringBootApplication
public class TodoServiceApplication {

    public static void main(String[] args) {
        //starts out Spring Boot Application with the given arguments
        SpringApplication.run(TodoServiceApplication.class, args);
    }

}
