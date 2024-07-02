package com.exercices.__exercice_spring_meubles.service;

import com.exercices.__exercice_spring_meubles.dao.FurnitureRepository;
import com.exercices.__exercice_spring_meubles.entities.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurnitures() {
        return furnitureRepository.findAll();
    }

    public Furniture saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
        return furniture;
    }

    public Furniture getFurnitureById(int id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteFurniture(Furniture furniture) {
        furnitureRepository.delete(furniture);
    }
}
