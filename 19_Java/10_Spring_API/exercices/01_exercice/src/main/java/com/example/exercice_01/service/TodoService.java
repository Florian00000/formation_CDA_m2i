package com.example.exercice_01.service;

import com.example.exercice_01.dto.TodoDtoPost;
import com.example.exercice_01.entity.Todo;
import com.example.exercice_01.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(TodoDtoPost todoDtoPost) {

        Todo todo = Todo.builder()
                .title(todoDtoPost.getTitle())
                .description(todoDtoPost.getDescription())
                .dueDate(LocalDate.parse(todoDtoPost.getDueDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .isValidate(todoDtoPost.isValidate())
                .build();

        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public boolean deleteTodoById(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todoRepository.delete(todo);
        }else return false;
        return true;
    }

    public Todo updateTodoById(int id, TodoDtoPost todoDtoPost) {
        Todo todo = getTodoById(id);
        if (todo == null) return null;

        todo.setTitle(todoDtoPost.getTitle());
        todo.setDescription(todoDtoPost.getDescription());
        todo.setDueDate(LocalDate.parse(todoDtoPost.getDueDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        todo.setValidate(todoDtoPost.isValidate());
        return todoRepository.save(todo);
    }

    public List<Todo> searchByValidate(boolean isValidate){
        List <Todo> todos = getAllTodos();
        if(isValidate){
            return todos.stream().filter(Todo::isValidate).toList();
        }else return todos.stream().filter(todo -> !todo.isValidate()).toList();
    }
}
