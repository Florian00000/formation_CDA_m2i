package org.example.exercice02AbstractFactoryCuisine.cuisine;

import org.example.exercice02AbstractFactoryCuisine.ingredient.Ingredient;
import org.example.exercice02AbstractFactoryCuisine.outilCuisine.OutilCuisine;
import org.example.exercice02AbstractFactoryCuisine.plat.Plat;

public abstract class CuisineFactory {
    public abstract Ingredient createIngredient();
    public abstract OutilCuisine createOutilCuisine();
    public abstract Plat createPlat();
}
