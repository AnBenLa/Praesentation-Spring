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

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/", method = GET)
    public String ToDoList(Model model){
        ToDo newToDo = new ToDo();
        model.addAttribute("todo", newToDo);
        model.addAttribute("ToDoList", toDoService.getToDoList());
        return "ToDo";
    }

    @RequestMapping(value = "/addToDo", method = POST)
    public String addToDo(@ModelAttribute(value="todo") ToDo toDo, Model model){
        toDo.creationDate = new Date();
        toDo.status = false;
        toDoService.addToDo(toDo);
        return "redirect:/";
    }

    //TODO remove ToDo

}
