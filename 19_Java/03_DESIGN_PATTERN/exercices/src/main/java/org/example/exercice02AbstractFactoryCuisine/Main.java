package org.example.exercice02AbstractFactoryCuisine;

import org.example.exercice02AbstractFactoryCuisine.cuisine.ItalienCuisine;
import org.example.exercice02AbstractFactoryCuisine.cuisine.JaponaisCuisine;
import org.example.exercice02AbstractFactoryCuisine.plat.Plat;

public class Main {
    public static void main(String[] args) {
        Restaurant resto1 = new Restaurant(new ItalienCuisine());
        Plat plat1 = resto1.getCuisine().createPlat();
        plat1.servir();

        resto1.setCuisine(new JaponaisCuisine());
        Plat plat2 = resto1.getCuisine().createPlat();
        plat2.servir();
    }
}
