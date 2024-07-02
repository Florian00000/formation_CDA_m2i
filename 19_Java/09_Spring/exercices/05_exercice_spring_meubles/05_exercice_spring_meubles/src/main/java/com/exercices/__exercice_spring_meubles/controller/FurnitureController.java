package com.exercices.__exercice_spring_meubles.controller;

import com.exercices.__exercice_spring_meubles.entities.Furniture;
import com.exercices.__exercice_spring_meubles.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FurnitureController {

    private final FurnitureService furnitureService;

    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String listFurniture(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurnitures());
        return "furnitures/furnituresList";
    }

    @GetMapping("/add")
    public String addFurniture(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furnitures/formFurniture";
    }

    @PostMapping("/add")
    public String addFurniture(@ModelAttribute("furniture") Furniture furniture) {
        furnitureService.saveFurniture(furniture);
        return "redirect:/";
    }

    //TODO gérer les cascades
    @GetMapping("/delete/{id}")
    public String deleteFurniture(@PathVariable("id") int id) {
        furnitureService.deleteFurniture(furnitureService.getFurnitureById(id));
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateFurniture(@PathVariable("id") int id, Model model) {
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "furnitures/formFurniture";
    }
}
