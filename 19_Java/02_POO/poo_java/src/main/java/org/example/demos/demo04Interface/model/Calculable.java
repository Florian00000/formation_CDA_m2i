package org.example.demos.demo04Interface.model;

public interface Calculable {
    double calculerAire();

    // Méthode par défaut
    default double calculerPerimetre(){
        return 0.0;
    }
}
