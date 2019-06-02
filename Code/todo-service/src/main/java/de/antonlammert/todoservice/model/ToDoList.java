package de.antonlammert.todoservice.model;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDo> toDoList;

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
