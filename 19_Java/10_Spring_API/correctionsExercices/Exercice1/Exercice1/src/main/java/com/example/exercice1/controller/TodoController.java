package com.example.exercice1.controller;

import com.example.exercice1.dto.TodoDtoGet;
import com.example.exercice1.dto.TodoDtoPost;
import com.example.exercice1.service.TodoService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo/")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("")
    public ResponseEntity<List<TodoDtoGet>> getAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDtoGet> getById (@PathVariable("id") int id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("validate")
    public ResponseEntity<List<TodoDtoGet>> getAllValidate (){
        return ResponseEntity.ok(service.findAllValidate());
    }

    @GetMapping("not_validate")
    public ResponseEntity<List<TodoDtoGet>> getAllNotValidate (){
        return ResponseEntity.ok(service.findAllNotValidate());
    }

    @PostMapping("add")
    public ResponseEntity<TodoDtoGet> createTodo (@RequestBody TodoDtoPost todoDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todoDtoPost));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TodoDtoGet> updateTodo (@PathVariable("id") int id,@RequestBody TodoDtoPost todoDtoPost){
        return ResponseEntity.ok(service.update(id,todoDtoPost));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo (@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.ok("Todo with id : "+id+" is delete");
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoDtoGet> changeStatus (@PathVariable("id")int id){
        return ResponseEntity.ok(service.changeStatus(id));
    }

}
