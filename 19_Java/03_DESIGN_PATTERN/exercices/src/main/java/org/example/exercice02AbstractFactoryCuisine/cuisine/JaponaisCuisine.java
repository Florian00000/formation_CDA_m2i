package org.example.exercice02AbstractFactoryCuisine.cuisine;

import org.example.exercice02AbstractFactoryCuisine.ingredient.Ingredient;
import org.example.exercice02AbstractFactoryCuisine.ingredient.JaponaisIngredient;
import org.example.exercice02AbstractFactoryCuisine.outilCuisine.JaponaisOutil;
import org.example.exercice02AbstractFactoryCuisine.outilCuisine.OutilCuisine;
import org.example.exercice02AbstractFactoryCuisine.plat.JaponaisPlat;
import org.example.exercice02AbstractFactoryCuisine.plat.Plat;

public class JaponaisCuisine extends CuisineFactory{
    @Override
    public Ingredient createIngredient() {
        return new JaponaisIngredient();
    }

    @Override
    public OutilCuisine createOutilCuisine() {
        return new JaponaisOutil();
    }

    @Override
    public Plat createPlat() {
        return new JaponaisPlat();
    }
}
