package org.example.exercices.exercice09Papeterie.model;

import java.util.UUID;

public abstract class ArticleUnitaire extends Article{

    private String nom;

    private  double pu;

    public ArticleUnitaire(UUID reference, String nom, double pu) {
        super(reference);
        this.nom = nom;
        this.pu = pu;
    }

    @Override
    public String toString() {
        return super.toString() + " nom : " + nom + " Prix Unitaire : " + pu;
    }

    @Override
    public double getPU() {
        return pu;
    }

    @Override
    public String getName(){
        return nom;
    }
}
