package com.example.exercice1.service;

import com.example.exercice1.dto.TodoDtoGet;
import com.example.exercice1.dto.TodoDtoPost;
import com.example.exercice1.entity.Todo;
import com.example.exercice1.exception.NotFoundException;
import com.example.exercice1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TodoDtoGet getById(int id){
        return todoToTodoDtoGet(findById(id));
    }

    public List<TodoDtoGet> findAll (){
        return todoListToToDtoGetList((List<Todo>) repository.findAll());
    }

    public TodoDtoGet create (TodoDtoPost todoDtoPost){

        Todo todo = Todo.builder()
                .title(todoDtoPost.getTitle())
                .description(todoDtoPost.getDescription())
                .date(LocalDate.parse(todoDtoPost.getDate(),dateFormatter))
                .build();

        repository.save(todo);
        return todoToTodoDtoGet(todo);
    }

    public TodoDtoGet update (int id , TodoDtoPost todoDtoPost){
        Todo todo = findById(id);
        todo.setTitle(todoDtoPost.getTitle());
        todo.setDescription(todoDtoPost.getDescription());
        todo.setDate(LocalDate.parse(todoDtoPost.getDate(),dateFormatter));

        repository.save(todo);
        return todoToTodoDtoGet(todo);
    }

    public boolean delete (int id){
        Todo todo = findById(id);
        repository.delete(todo);
        return true;
    }

    public TodoDtoGet changeStatus (int id){
        Todo todo = findById(id);
        todo.setValidate(!todo.isValidate());
        repository.save(todo);
        return todoToTodoDtoGet(todo);
    }

    public List<TodoDtoGet> findAllValidate(){
        List<Todo> todos = repository.findByValidate(true);
        return todoListToToDtoGetList(todos);
    }

    public List<TodoDtoGet> findAllNotValidate(){
        List<Todo> todos = repository.findByValidate(false);
        return todoListToToDtoGetList(todos);
    }

    private Todo findById (int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }


    private TodoDtoGet todoToTodoDtoGet (Todo todo){
        return TodoDtoGet.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .date(todo.getDate())
                .isValidate(todo.isValidate())
                .build();
    }

    private List<TodoDtoGet> todoListToToDtoGetList(List<Todo> todoList){
        return todoList.stream().map(this::todoToTodoDtoGet).collect(Collectors.toList());
    }

}
