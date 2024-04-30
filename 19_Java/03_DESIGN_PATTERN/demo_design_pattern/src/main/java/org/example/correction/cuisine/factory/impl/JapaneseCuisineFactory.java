package org.example.correction.cuisine.factory.impl;

import org.example.correction.cuisine.entity.CookingUtensil;
import org.example.correction.cuisine.entity.Dish;
import org.example.correction.cuisine.entity.Ingredient;
import org.example.correction.cuisine.entity.impl.JapaneseCookingUtensil;
import org.example.correction.cuisine.entity.impl.JapaneseDish;
import org.example.correction.cuisine.entity.impl.JapaneseIngredient;
import org.example.correction.cuisine.factory.CuisineFactory;

public class JapaneseCuisineFactory extends CuisineFactory {
    @Override
    public Dish createDish() {
        return new JapaneseDish();
    }

    @Override
    public Ingredient createIngredient() {
        return new JapaneseIngredient();
    }

    @Override
    public CookingUtensil createCookingUtensil() {
        return new JapaneseCookingUtensil();
    }
}
