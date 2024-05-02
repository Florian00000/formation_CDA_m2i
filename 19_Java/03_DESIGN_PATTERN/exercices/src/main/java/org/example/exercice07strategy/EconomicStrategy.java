package org.example.exercice07strategy;

public class EconomicStrategy implements NavigationStrategy{
    @Override
    public void navigate(String destination) {
        System.out.println("prend ton vélo " + destination);
    }
}
