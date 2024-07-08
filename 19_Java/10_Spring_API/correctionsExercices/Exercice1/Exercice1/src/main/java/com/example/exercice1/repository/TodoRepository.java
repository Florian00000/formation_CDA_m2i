package com.example.exercice1.repository;

import com.example.exercice1.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {
    List<Todo> findByValidate (boolean validate);
}
