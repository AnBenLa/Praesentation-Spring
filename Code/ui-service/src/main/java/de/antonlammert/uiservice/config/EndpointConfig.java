package de.antonlammert.uiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

//indicates that the class declares beans
@Configuration
public class EndpointConfig{

    //injects the value of the "endpoint.todo-service" property in the application.properties into the variable todoservice
    @Value("${endpoint.todo-service}")
    public String todoservice;

}