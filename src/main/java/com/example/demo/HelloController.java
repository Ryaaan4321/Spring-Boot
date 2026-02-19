package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



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
    
       
}
