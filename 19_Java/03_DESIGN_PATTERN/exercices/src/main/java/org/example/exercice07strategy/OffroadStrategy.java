package org.example.exercice07strategy;

public class OffroadStrategy implements NavigationStrategy{
    @Override
    public void navigate(String destination) {
        System.out.println("pick-up toyota vroum vroum " + destination + " + grosse kalash");
    }
}
