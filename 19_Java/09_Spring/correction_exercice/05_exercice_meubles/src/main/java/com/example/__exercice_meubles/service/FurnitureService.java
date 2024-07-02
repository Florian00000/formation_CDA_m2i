package com.example.__exercice_meubles.service;

import com.example.__exercice_meubles.dao.FurnitureRepository;
import com.example.__exercice_meubles.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService implements IFurnitureService{
    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture saveFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    @Override
    public Furniture getFurnitureById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFuniture(Long id) {
        furnitureRepository.deleteById(id);
    }
}
