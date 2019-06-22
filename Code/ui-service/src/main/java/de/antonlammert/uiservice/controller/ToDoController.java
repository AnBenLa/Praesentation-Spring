package de.antonlammert.uiservice.controller;

import de.antonlammert.uiservice.model.ToDo;
import de.antonlammert.uiservice.resources.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//signals Spring to take this class into account for external web-requests
@Controller
public class ToDoController {

    //injects the bean ToDoService from the spring context
    @Autowired
    private ToDoService toDoService;

    /**
     * gets invoked if there is a get request on the root path ("/").
     * returns the ToDo.html file populated with the already existing ToDos
     * @param model the model that contains the thymeleaf data from the former call
     * @return the ToDo.html file
     */
    @RequestMapping(value = "/", method = GET)
    public String ToDoList(Model model){
        ToDo newToDo = new ToDo();
        //adds an empty ToDo-object to the model so that it can be filled with data via thymeleaf
        //this filled ToDo-object can be used to add a new todo
        model.addAttribute("todo", newToDo);
        //adds a ToDoList object to the model that contains all the ToDos from the toDoService
        model.addAttribute("ToDoList", toDoService.getToDoList());
        //returns the ToDo.html
        return "ToDo";
    }

    /**
     * gets invoked if there is a post request on path "/addToDo"
     * @ModelAttribute allows us to use the values set within the model Attributes from the former call
     * @param toDo the toDo that should be added
     * @param model the model that contains the thymeleaf data from the former call
     * @return redirects to the root path (invokes ToDoList(Model model)
     */
    @RequestMapping(value = "/addToDo", method = POST)
    public String addToDo(@ModelAttribute(value="todo") ToDo toDo, Model model){
        toDo.creationDate = new Date();
        toDo.status = false;
        toDoService.addToDo(toDo);
        //redirects to root path
        return "redirect:/";
    }

    /**
     * gets invoked if there is a post request on path "/deleteToDo"
     * @ModelAttribute allows us to use the values set within the model Attributes from the former call
     * @param toDo a toDo with the id oth the todo that should be deleted
     * @param model the model that contains the thymeleaf data from the former call
     * @return redirects to the root path (invokes ToDoList(Model model)
     */
    @RequestMapping(value = "/deleteToDo", method = POST)
    public String removeToDo(@ModelAttribute(value="todo") ToDo toDo, Model model){
        toDoService.removeToDo(toDo.id);
        //redirects to root path
        return "redirect:/";
    }
}
