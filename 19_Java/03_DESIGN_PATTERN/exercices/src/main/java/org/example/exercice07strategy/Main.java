package org.example.exercice07strategy;

public class Main {
    public static void main(String[] args) {
        NavigationSystem voiture = new NavigationSystem(new RoadStrategy());

        voiture.allerCaRoule("Samarcande");
        voiture.setNavigationStrategy(new OffroadStrategy());
        voiture.allerCaRoule("Québec");
    }
}
