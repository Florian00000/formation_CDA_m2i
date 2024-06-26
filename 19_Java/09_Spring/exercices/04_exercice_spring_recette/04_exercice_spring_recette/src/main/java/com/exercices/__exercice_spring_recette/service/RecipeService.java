package com.exercices.__exercice_spring_recette.service;

import com.exercices.__exercice_spring_recette.model.Category;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecipeService {

    private Map<UUID, Category> categories;

    public RecipeService() {
        System.out.println("je suis un service instancié ^^");
        this.categories = new HashMap<>();
        Category category = Category.builder().name("française").description("blabla").build();
        addCategory(category);
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
}
