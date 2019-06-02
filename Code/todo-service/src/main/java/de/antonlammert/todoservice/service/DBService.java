package de.antonlammert.todoservice.service;

import de.antonlammert.todoservice.model.ToDo;
import de.antonlammert.todoservice.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ToDoList getList(){
        ArrayList<ToDo> list = new ArrayList<>();
        for(ToDo todo : mongoTemplate.findAll(ToDo.class)){
            list.add(todo);
        }
        return new ToDoList(list);
    }

    public void addToDo(ToDo todo){
        mongoTemplate.save(todo);
    }
}
