package org.example.correction.cuisine.entity.impl;

import org.example.correction.cuisine.entity.Dish;

public class ItalianDish extends Dish {
    @Override
    public void serve() {
        System.out.println("Serve italian Dish's");
    }
}
