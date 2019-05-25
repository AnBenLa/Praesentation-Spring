package com.example.demo.api;

import com.example.demo.model.TestObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @RequestMapping(value = "/getObject",method = GET)
    public TestObject getTestObject(){
        return new TestObject("Hello World from Service 2");
    }
}
