package com.example.exercice_cinematheque_02.repository;

import com.example.exercice_cinematheque_02.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
