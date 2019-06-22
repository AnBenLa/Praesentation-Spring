package de.antonlammert.todoservice.model;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDo> toDoList;

    //the empty constructor as well as the setter and getter are necessary for the rest-template to initialize the object
    public ToDoList() {
    }

    public ToDoList(ArrayList<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public ArrayList<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<ToDo> toDoList) {
        this.toDoList = toDoList;
    }
}
