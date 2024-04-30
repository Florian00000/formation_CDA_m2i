package org.example.correction.cuisine;

import org.example.correction.cuisine.entity.Restaurant;
import org.example.correction.cuisine.factory.impl.ItalianCuisineFactory;
import org.example.correction.cuisine.factory.impl.JapaneseCuisineFactory;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(new JapaneseCuisineFactory());
        restaurant.make();
        restaurant.setCuisineFactory(new ItalianCuisineFactory());
        restaurant.make();
    }
}
