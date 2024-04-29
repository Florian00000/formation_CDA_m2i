package org.example.exercice02AbstractFactoryCuisine.cuisine;

import org.example.exercice02AbstractFactoryCuisine.ingredient.Ingredient;
import org.example.exercice02AbstractFactoryCuisine.ingredient.ItalienIngredient;
import org.example.exercice02AbstractFactoryCuisine.outilCuisine.ItalienOutil;
import org.example.exercice02AbstractFactoryCuisine.outilCuisine.OutilCuisine;
import org.example.exercice02AbstractFactoryCuisine.plat.ItalienPlat;
import org.example.exercice02AbstractFactoryCuisine.plat.Plat;

public class ItalienCuisine extends CuisineFactory{
    @Override
    public Ingredient createIngredient() {
        return new ItalienIngredient();
    }

    @Override
    public OutilCuisine createOutilCuisine() {
        return new ItalienOutil();
    }

    @Override
    public Plat createPlat() {
        return new ItalienPlat();
    }
}
