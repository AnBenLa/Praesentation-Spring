package com.example.demo.api;

import com.example.demo.model.TestObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/test")
public class TestEndpoint {

    @RequestMapping(value = "/getObject",method = GET)
    public TestObject getTestObject(){
        return new TestObject("Hello World from Service 1");
    }

    @RequestMapping(value = "/getObjectFromService2", method = GET)
    public TestObject getTestObjectFromService2(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:9091/test/getObject",TestObject.class);
    }
}
