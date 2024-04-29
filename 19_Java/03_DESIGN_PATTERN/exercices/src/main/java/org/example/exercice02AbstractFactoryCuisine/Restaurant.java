package org.example.exercice02AbstractFactoryCuisine;

import org.example.exercice02AbstractFactoryCuisine.cuisine.CuisineFactory;

public class Restaurant {
    private CuisineFactory cuisine;

    public Restaurant(CuisineFactory cuisine) {
        this.cuisine = cuisine;
    }

    public CuisineFactory getCuisine() {
        return cuisine;
    }

    public void setCuisine(CuisineFactory cuisine) {
        this.cuisine = cuisine;
    }
}
