package de.antonlammert.todoservice.service;

import de.antonlammert.todoservice.model.ToDo;
import de.antonlammert.todoservice.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//marks this bean to indicate that it is holding the business logic
@Service
public class DBService {

    //injects the bean MongoTemplate from the spring context
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * adds all ToDo objects in our database with status=false to a ToDoList
     * @return ToDoList object with all the unfinished ToDos
     */
    public ToDoList getList(){
        ArrayList<ToDo> list = new ArrayList<>();
        for(ToDo todo : mongoTemplate.findAll(ToDo.class)){
            if(!todo.status) {
                list.add(todo);
            }
        }
        return new ToDoList(list);
    }

    /**
     * Saves a new ToDo objecto to our database. Sets the id variable itself
     * @param todo the new Todo that should be added
     */
    public void addToDo(ToDo todo){
        mongoTemplate.save(todo);
    }

    /**
     * sets the status of the ToDo with the given id to true (ToDo was finished)
     * @param id the id of the finished ToDo
     */
    public void removeToDo(String id){
        //creates new Query to find ToDo with the given id
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        //executes Query
        ToDo todo = mongoTemplate.findOne(query, ToDo.class);
        if(todo != null)
            //set status of ToDo to true
            todo.setStatus(true);
        mongoTemplate.save(todo);
    }
}
