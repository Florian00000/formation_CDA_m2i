package com.example.__exercice_meubles.service;

import com.example.__exercice_meubles.entity.Furniture;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> getAllFurniture();
    Furniture saveFurniture(Furniture furniture);
    Furniture getFurnitureById(Long id);
    void deleteFuniture(Long id);

}
