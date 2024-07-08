package com.example.exercice_01.controller;

import com.example.exercice_01.dto.TodoDtoPost;
import com.example.exercice_01.entity.Todo;
import com.example.exercice_01.exception.NotFoundException;
import com.example.exercice_01.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@RequestBody TodoDtoPost todoDtoPost) {
        Todo todo = todoService.addTodo(todoDtoPost);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@RequestParam(required = false) Boolean validate ) {
        if (validate != null) {
            return new ResponseEntity<>(todoService.searchByValidate(validate), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) throws NotFoundException {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            throw new NotFoundException();
        }else{
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) throws NotFoundException {
        boolean result = todoService.deleteTodoById(id);
        if (result) {
            return new ResponseEntity<>("Todo " + id + " supprimée avec succès", HttpStatus.OK);
        }else {
            throw new NotFoundException();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestBody TodoDtoPost todoDtoPost) throws NotFoundException {
        Todo todo = todoService.updateTodoById(id, todoDtoPost);
        if (todo == null) {
            throw new NotFoundException();
        }else return new ResponseEntity<>(todo, HttpStatus.OK);
    }


}
