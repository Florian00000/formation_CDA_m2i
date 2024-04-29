package org.example.exercice01BuilderPizza;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.PizzaBuilder().taille(Pizza.Taille.MOYENNE)
                .typePate(Pizza.TypePate.FINE)
                .fromage(Pizza.Fromage.MOZZARELLA)
                .fromage(Pizza.Fromage.CHEDDAR)
                .build();
        Pizza pizza2 = new Pizza.PizzaBuilder().build();
        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
