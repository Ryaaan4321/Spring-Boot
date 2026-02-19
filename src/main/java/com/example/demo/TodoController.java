package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todos = new ArrayList<>();
    private int counter = 1;

    @PostMapping("/create")
    public String postMethodName(@RequestBody Todo request) {
        String title = request.getTitle();
        String description = request.getDescription();
        return "saved";
    }

    @GetMapping("/get-todos")
    public List<Todo> getMethodName() {
        return todos;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo entity) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                if (!entity.getTitle().isEmpty()) {
                    todo.setTitle(entity.getTitle());
                }
                if (!entity.getDescription().isEmpty()) {
                    todo.setDescription(entity.getDescription());
                }
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        todos.removeIf(t -> t.getId() == id);
        return "Deleted";
    }
}
