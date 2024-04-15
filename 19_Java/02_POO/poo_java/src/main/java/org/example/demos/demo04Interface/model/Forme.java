package org.example.demos.demo04Interface.model;


// implementation d'une interface avec le mot clé implements
public abstract class Forme implements Calculable{

    protected String nom;

    public Forme(String nom) {
        this.nom = nom;
    }


    @Override
    public double calculerAire() {
        return 0;
    }

}
