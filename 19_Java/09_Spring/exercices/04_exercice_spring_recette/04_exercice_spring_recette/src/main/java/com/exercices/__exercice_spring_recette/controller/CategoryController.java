package com.exercices.__exercice_spring_recette.controller;

import com.exercices.__exercice_spring_recette.model.Category;
import com.exercices.__exercice_spring_recette.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CategoryController {

    private final RecipeService recipeService;

    @Autowired
    public CategoryController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", recipeService.getAllCategories());
        return "categories/categoriesList";
    }

    @GetMapping("/categories/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categories/categoryForm";
    }

    @PostMapping("/categories/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/categoryForm";
        }else {
            if (category.getId() == null) {
                recipeService.addCategory(category);
            }else {
                recipeService.updateCategory(category);
            }
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable("id") UUID id, Model model) {
        Category category = recipeService.getCategory(id);
        model.addAttribute("category", category);
        return "categories/categoryForm";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") UUID id) {
        recipeService.deleteCategory(id);
        return "redirect:/categories";
    }
}
