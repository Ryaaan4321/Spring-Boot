package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Todo;
import com.example.demo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;
    public TodoController(TodoService service){
        this.service=service;
    }
    @PostMapping("/create")
    public String create(@RequestBody Todo todo) {
        service.createTodo(todo);
        return "saved";
    }
    @GetMapping("/get-todos")
    public List<Todo> get() {
        return service.getTodos();
    }
    @PutMapping("/{id}")
    public Todo put(@PathVariable int id, @RequestBody Todo entity) {
        return service.updateTodo(id, entity);
    }
    @DeleteMapping("/{id}")
    public String delte(@PathVariable int id){
        return service.deleteTodo(id);
    }
}
