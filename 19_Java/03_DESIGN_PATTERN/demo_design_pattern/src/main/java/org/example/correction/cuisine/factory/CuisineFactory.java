package org.example.correction.cuisine.factory;

import org.example.correction.cuisine.entity.CookingUtensil;
import org.example.correction.cuisine.entity.Dish;
import org.example.correction.cuisine.entity.Ingredient;

public abstract class CuisineFactory {

    public abstract Dish createDish();
    public abstract Ingredient createIngredient();
    public abstract CookingUtensil createCookingUtensil();
}
