package com.example.exercice_cinematheque_02.repository;

import com.example.exercice_cinematheque_02.entity.Director;
import com.example.exercice_cinematheque_02.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List <Movie> findAllByDirector(Director director);
}
