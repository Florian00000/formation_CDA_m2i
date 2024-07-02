package com.example.__exercice_meubles.dao;

import com.example.__exercice_meubles.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    // Furniture findByName(String name);
}
