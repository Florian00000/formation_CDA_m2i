package com.exercices.__exercice_spring_recette.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    private final RecipeController recipeController;

    @Autowired
    public CategoryController(RecipeController recipeController) {
        this.recipeController = recipeController;
    }

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        return "categories/categoriesList";
    }
}
