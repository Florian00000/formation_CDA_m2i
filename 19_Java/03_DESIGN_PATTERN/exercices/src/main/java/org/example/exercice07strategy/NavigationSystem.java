package org.example.exercice07strategy;

public class NavigationSystem {
    private NavigationStrategy navigationStrategy;

    public NavigationSystem(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void allerCaRoule( String destination){
        this.navigationStrategy.navigate(destination);
    }
}
