package com.example.exercice2.repository;

import com.example.exercice2.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film,Integer> {
}
