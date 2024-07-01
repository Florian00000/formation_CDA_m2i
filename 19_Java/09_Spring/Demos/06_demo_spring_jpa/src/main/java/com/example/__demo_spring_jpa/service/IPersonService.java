package com.example.__demo_spring_jpa.service;

import com.example.__demo_spring_jpa.entity.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();
    Person findById(int id);
    Person save(Person person);
    Person update(Person person);
    void delete(Person person);
}
