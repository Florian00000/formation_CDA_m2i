package com.example.exercice_02.controller;

import com.example.exercice_02.model.Task;
import com.example.exercice_02.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @PatchMapping("/{id}")
    public ResponseEntity<Task> taskCompleted(@PathVariable int id) {
            return ResponseEntity.ok(tasksService.updateTask(id));

    }
}
