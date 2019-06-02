package de.antonlammert.uiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfig{

    @Value("${endpoint.todo-service}")
    public String todoservice;

}