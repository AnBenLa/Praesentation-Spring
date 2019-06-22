package de.antonlammert.uiservice.model;

import java.util.Date;

public class ToDo {

    public String id;
    public String content;
    public Date creationDate;
    public Boolean status;

    //the empty constructor as well as the setter and getter are necessary for the rest-template to initialize the object
    public ToDo() {
    }

    public ToDo(String id, String content, Date creationDate, Boolean status) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.status = status;
    }

    public ToDo(String content, Date creationDate, Boolean status) {
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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
