package com.example.rest.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//How users interact with api

//entry point
@RestController
public class GreetingController {
    private static final String template = "Hello %s";
    //sets id for greeting
    private static AtomicLong counter = new AtomicLong();

    //sets get request
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name){
        //Returns either hello world or name from param value
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
