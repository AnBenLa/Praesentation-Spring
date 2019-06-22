package de.antonlammert.todoservice.api;

import de.antonlammert.todoservice.model.ToDo;
import de.antonlammert.todoservice.model.ToDoList;
import de.antonlammert.todoservice.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//signals Spring to take this class into account for external rest-calls
@RestController
public class ToDoEndpoint {

    //injects the bean DBService from the spring context
    @Autowired
    DBService dbService;

    /**
     * gets invoked if there is a get request on the path "/getToDoList"
     * @return a ToDoList object filled with all unfinished (status = false) ToDos in our database
     */
    @RequestMapping(value = "/getToDoList", method = GET)
    public ToDoList returnList(){
        return dbService.getList();
    }

    /**
     * gets invoked if there is a post request on the path "/addToDo"
     * adds a new ToDo to our databse
     * @param todo the Todo that should be added
     */
    @RequestMapping(value = "/addToDo", method = POST)
    public void addToDo(@RequestBody ToDo todo){
        dbService.addToDo(todo);
    }

    /**
     * gets invoked if there is delete request on the path "/removeToDo/{id}"
     * @PathVariable allows us to use the String after "/removeToDo/" as an input
     * @param id the id of the ToDo that should be "removed" (status = true)
     */
    @RequestMapping(value = "/removeToDo/{id}", method = DELETE)
    public void removeToDo(@PathVariable("id") String id) {
        dbService.removeToDo(id);
    }
}
