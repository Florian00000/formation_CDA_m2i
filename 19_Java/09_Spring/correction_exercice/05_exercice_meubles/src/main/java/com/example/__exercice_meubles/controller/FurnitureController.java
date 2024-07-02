package com.example.__exercice_meubles.controller;

import com.example.__exercice_meubles.entity.Furniture;
import com.example.__exercice_meubles.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FurnitureController {
    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String getAllFurnitures(Model model){
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "furnitures-list";
    }

    @GetMapping("/furnitureForm")
    public String furnitureForm(Model model){
        model.addAttribute("furniture", new Furniture());
        return "furniture-form";
    }

    @PostMapping("/addFurniture")
    public String addFurniture(@ModelAttribute("furniture") Furniture furniture){
        furnitureService.saveFurniture(furniture);
        return "redirect:/";
    }

    @GetMapping("/furniture/edit/{id}")
    public String editFurniture(@PathVariable Long id, Model model){
        model.addAttribute("furniture", furnitureService.getFurnitureById(id));
        return "furniture-form";
    }

    @GetMapping("/furniture/delete/{id}")
    public String deleteFurniture(@PathVariable Long id){
        furnitureService.deleteFuniture(id);
        return "redirect:/";
    }
}
