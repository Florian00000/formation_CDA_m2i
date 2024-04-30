package org.example.correction.cuisine.entity.impl;

import org.example.correction.cuisine.entity.Ingredient;

public class ItalianIngredient extends Ingredient {

    @Override
    public void prepare() {
        System.out.println("Prepare Italian Ingredient");
    }
}
