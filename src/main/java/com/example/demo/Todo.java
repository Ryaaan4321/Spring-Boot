package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    public String description;

    public Todo() {
    }
    public Todo(String title,String description){
        this.title=title;
        this.description=description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription(){
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description){
        this.description=description;
    }
}
