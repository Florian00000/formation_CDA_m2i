package org.example.correction.cuisine.entity;

import org.example.correction.cuisine.factory.CuisineFactory;

public class Restaurant {
    private Dish dish;
    private Ingredient ingredient;
    private CookingUtensil cookingUtensil;

//    private CuisineFactory cuisineFactory;
    public Restaurant(CuisineFactory cuisineFactory) {
        setCuisineFactory(cuisineFactory);
    }

    public void setCuisineFactory(CuisineFactory cuisineFactory) {
        dish = cuisineFactory.createDish();
        ingredient = cuisineFactory.createIngredient();
        cookingUtensil =cuisineFactory.createCookingUtensil();
    }

    public void make() {
        ingredient.prepare();
        cookingUtensil.use();
        dish.serve();
    }
}
