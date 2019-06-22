package de.antonlammert.uiservice.resources;

import de.antonlammert.uiservice.config.EndpointConfig;
import de.antonlammert.uiservice.model.ToDo;
import de.antonlammert.uiservice.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//marks this bean to indicate that it is holding the business logic
@Service
public class ToDoService {

    //injects the bean EndpointConfig from the spring context
    @Autowired
    private EndpointConfig config;

    /**
     * creates a rest call to the todo-service to get a ToDoList object with all the unfinished ToDos in our database
     * @return ToDoList object
     */
    public ToDoList getToDoList(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(config.todoservice + "/getToDoList", ToDoList.class);
    }

    /**
     * creates a post to the todo-services with the ToDo that should be added
     * @param toDo the ToDo that should be added to our database
     */
    public void addToDo(ToDo toDo){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(config.todoservice + "/addToDo", toDo ,ToDo.class);
    }

    /**
     * sets the status of the ToDo with the given id from our Database to true (it is now finished)
     * @param id the id of the ToDo that should be removed from the list of unfinished ToDos
     */
    public void removeToDo(String id){
        RestTemplate restTemplate = new RestTemplate();
        String url = config.todoservice + "/removeToDo/" + id;
        restTemplate.delete(url);
    }
}
