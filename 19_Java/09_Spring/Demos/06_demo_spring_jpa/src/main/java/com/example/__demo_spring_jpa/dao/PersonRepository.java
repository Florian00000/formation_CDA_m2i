package com.example.__demo_spring_jpa.dao;

import com.example.__demo_spring_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
