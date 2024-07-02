package com.exercices.__exercice_spring_meubles.dao;

import com.exercices.__exercice_spring_meubles.entities.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
}
