package com.example.__demo_spring_jpa.service;

import com.example.__demo_spring_jpa.dao.PersonRepository;
import com.example.__demo_spring_jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{
    private PersonRepository personRepository;

    @Autowired
    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }
}
