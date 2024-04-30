package org.example.correction.cuisine.entity.impl;

import org.example.correction.cuisine.entity.Dish;

public class JapaneseDish extends Dish {
    @Override
    public void serve() {
        System.out.println("Serve japanese Dish's");
    }
}
