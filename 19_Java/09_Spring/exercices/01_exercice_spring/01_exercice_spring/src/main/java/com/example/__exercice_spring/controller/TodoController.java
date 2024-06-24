package com.example.__exercice_spring.controller;

import com.example.__exercice_spring.model.Todo;
import com.example.__exercice_spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todos/getOne")
    public String getOneTodo(Model model){
        model.addAttribute("todo", todoService.getOneTodo());

        return "todos/todo";
    }

    @RequestMapping("/todos/getAll")
    @ResponseBody
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
