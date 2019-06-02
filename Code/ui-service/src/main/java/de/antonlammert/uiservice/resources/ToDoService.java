package de.antonlammert.uiservice.resources;

import de.antonlammert.uiservice.config.EndpointConfig;
import de.antonlammert.uiservice.model.ToDo;
import de.antonlammert.uiservice.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ToDoService {

    @Autowired
    private EndpointConfig config;

    public ToDoList getToDoList(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(config.todoservice + "/getToDoList", ToDoList.class);
    }

    public void addToDo(ToDo toDo){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(config.todoservice + "/addToDo", toDo ,ToDo.class);
    }

    public void removeToDo(){

    }
}
