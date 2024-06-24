package com.example.__exercice_spring.service;

import com.example.__exercice_spring.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TodoService {

    public Todo getOneTodo(){
         return Todo.builder().name("exemple1").description("exemple").isDone(true).build();
    }

    public List<Todo> getAllTodos(){
        return List.of(
                Todo.builder().name("exemple1").description("exemple").isDone(true).build(),
                Todo.builder().name("exemple2").description("exemple").isDone(false).build());
    }
}
