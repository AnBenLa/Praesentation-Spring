package de.antonlammert.todoservice.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class ToDo {

    //the @id annotation will allow spring to set the value itself when saving the object to our database
    @Id
    public String Id;
    public String content;
    public Date creationDate;
    public Boolean status;

    //the empty constructor as well as the setter and getter are necessary for the rest-template to initialize the object
    public ToDo() {
    }

    public ToDo(String id, String content, Date creationDate, Boolean status) {
        Id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
