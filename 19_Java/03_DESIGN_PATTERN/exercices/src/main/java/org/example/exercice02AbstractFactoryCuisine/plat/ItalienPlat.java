package org.example.exercice02AbstractFactoryCuisine.plat;

public class ItalienPlat extends Plat {
    @Override
    public void servir() {
        System.out.println(" ~~ Je suis un plat Italien ~~");
    }
}
