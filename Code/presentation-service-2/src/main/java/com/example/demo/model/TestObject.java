package com.example.demo.model;

public class TestObject {

    public TestObject() {
    }

    public TestObject(String content) {
        this.content = content;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
