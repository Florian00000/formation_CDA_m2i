package org.example.correction.cuisine.factory.impl;

import org.example.correction.cuisine.entity.CookingUtensil;
import org.example.correction.cuisine.entity.Dish;
import org.example.correction.cuisine.entity.Ingredient;
import org.example.correction.cuisine.entity.impl.*;
import org.example.correction.cuisine.factory.CuisineFactory;

public class ItalianCuisineFactory extends CuisineFactory {
    @Override
    public Dish createDish() {
        return new ItalianDish();
    }

    @Override
    public Ingredient createIngredient() {
        return new ItalianIngredient();
    }

    @Override
    public CookingUtensil createCookingUtensil() {
        return new ItalianCookingUtensil();
    }
}
