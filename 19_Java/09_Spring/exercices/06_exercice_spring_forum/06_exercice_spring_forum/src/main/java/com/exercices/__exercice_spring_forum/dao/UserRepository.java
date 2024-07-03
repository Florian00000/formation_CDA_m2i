package com.exercices.__exercice_spring_forum.dao;

import com.exercices.__exercice_spring_forum.entitie.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
}
