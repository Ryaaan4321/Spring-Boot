package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HelloController {
    @GetMapping("/")
    public String Home() {
        return "we are learning the spring boot";
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello from the spring Boot";
    }
    @GetMapping("/json")
    public Map<String,String> json(){
        return Map.of(
                "message", "Hello from Spring Boot",
                "status", "success"
        );
    } 
    @GetMapping("/greet")
    // to pass the params we do this
    public  Map<String,String> greet(@RequestParam String name) {
        return Map.of(
            "greeting","hello " + name
        );
    }
}
