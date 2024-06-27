package com.exercices.__exercice_spring_recette.controller;

import com.exercices.__exercice_spring_recette.model.Category;
import com.exercices.__exercice_spring_recette.model.Recipe;
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
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getAllCategories(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes/recipesList";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable UUID id) {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", recipe);
        return "recipes/recipeDetail";
    }

    @GetMapping("/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", recipeService.getAllCategories());
        return "recipes/recipeForm";
    }

    @PostMapping("/add")
    public String addRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/add";
        }else {
            UUID id = UUID.fromString(recipe.getCategoryId());
            Category category = recipeService.getCategory(id);
            recipe.setCategory(category);
            if (recipe.getId() == null) {
                recipeService.addRecipe(recipe);
            }else{
                recipeService.updateRecipe(recipe);
            }

        }
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateRecipe(Model model, @PathVariable("id") UUID id) {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", recipeService.getAllCategories());
        return "recipes/recipeForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe( @PathVariable("id") UUID id) {
        recipeService.deleteRecipe(id);
        return "redirect:/";
    }
}
