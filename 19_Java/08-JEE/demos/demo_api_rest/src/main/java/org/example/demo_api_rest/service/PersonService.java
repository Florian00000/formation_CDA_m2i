package org.example.demo_api_rest.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.demo_api_rest.Person;


@ApplicationScoped
public class PersonService {

    public Person save(int id,String name,int age){
        return new Person(id,name,age);
    }
}
