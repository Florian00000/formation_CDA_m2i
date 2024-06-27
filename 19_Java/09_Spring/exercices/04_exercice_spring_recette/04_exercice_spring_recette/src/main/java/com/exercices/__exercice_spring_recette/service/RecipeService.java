package com.exercices.__exercice_spring_recette.service;

import com.exercices.__exercice_spring_recette.model.Category;
import com.exercices.__exercice_spring_recette.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecipeService {

    private Map<UUID, Category> categories;
    private Map<UUID, Recipe> recipes;

    public RecipeService() {
        //catégories
        System.out.println("je suis un service instancié ^^");
        this.categories = new HashMap<>();
        Category category = Category.builder().name("française").description("blabla").build();
        addCategory(category);

        //Recettes
        this.recipes = new HashMap<>();
        Recipe recipe = Recipe.builder()
                .name("frites").ingredients(List.of("patates", "grass")).instructions("blabla").category(category).build();
        addRecipe(recipe);
    }

    public void addCategory(Category category) {
        category.setId(UUID.randomUUID());
        this.categories.put(category.getId(), category);
    }

    public List<Category> getAllCategories() {
        return categories.values().stream().toList();
    }

    public Category getCategory(UUID id) {
        return categories.get(id);
    }

    public void deleteCategory(UUID id) {
        this.categories.remove(id);
    }

    public void updateCategory(Category category) {
        this.categories.replace(category.getId(), category);
    }

    //Recettes

    public List<Recipe> getAllRecipes() {
        return recipes.values().stream().toList();
    }

    public void addRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        this.recipes.put(recipe.getId(), recipe);
    }

    public Recipe getRecipe(UUID id) {
        return recipes.get(id);
    }

    public void deleteRecipe(UUID id) {
        this.recipes.remove(id);
    }

    public void updateRecipe(Recipe recipe) {
        this.recipes.replace(recipe.getId(), recipe);
    }
}
