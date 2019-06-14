package de.antonlammert.todoservice.service;

import de.antonlammert.todoservice.model.ToDo;
import de.antonlammert.todoservice.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ToDoList getList(){
        ArrayList<ToDo> list = new ArrayList<>();
        for(ToDo todo : mongoTemplate.findAll(ToDo.class)){
            if(!todo.status) {
                list.add(todo);
            }
        }
        return new ToDoList(list);
    }

    public void addToDo(ToDo todo){
        mongoTemplate.save(todo);
    }

    public void removeToDo(String id){
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        ToDo todo = mongoTemplate.findOne(query, ToDo.class);
        if(todo != null)
            todo.setStatus(true);
        mongoTemplate.save(todo);
    }
}
