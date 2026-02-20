package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Todo;
import com.example.demo.repository.TodoRepository;
@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public String createTodo(Todo request) {
        Todo t = new Todo(request.getTitle(), request.getDescription());
        repository.save(t);
        return "saved";
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo updateTodo(int id, Todo entity) {

        Todo todo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (entity.getTitle() != null) {
            todo.setTitle(entity.getTitle());
        }

        if (entity.getDescription() != null) {
            todo.setDescription(entity.getDescription());
        }

        return repository.save(todo);
    }

    public String deleteTodo(int id) {
        repository.deleteById(id);
        return "deleted";
    }
}