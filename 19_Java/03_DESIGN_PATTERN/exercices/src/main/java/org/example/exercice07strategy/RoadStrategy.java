package org.example.exercice07strategy;

public class RoadStrategy implements NavigationStrategy {
    @Override
    public void navigate(String destination) {
        System.out.println("navigation routière à destination de " + destination);
    }
}
