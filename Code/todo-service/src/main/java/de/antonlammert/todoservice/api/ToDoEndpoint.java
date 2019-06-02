package de.antonlammert.todoservice.api;

import de.antonlammert.todoservice.model.ToDo;
import de.antonlammert.todoservice.model.ToDoList;
import de.antonlammert.todoservice.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ToDoEndpoint {

    @Autowired
    DBService dbService;

    @RequestMapping(value = "/getToDoList", method = GET)
    public ToDoList returnList(){
        return dbService.getList();
    }

    @RequestMapping(value = "/addToDo", method = POST)
    public void addToDo(@RequestBody ToDo todo){
        dbService.addToDo(todo);
    }

    @RequestMapping(value = "/removeToDo", method = POST)
    public void removeToDo(){

    }
}
