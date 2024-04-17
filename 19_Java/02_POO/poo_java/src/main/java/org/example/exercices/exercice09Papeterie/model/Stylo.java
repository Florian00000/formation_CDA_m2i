package org.example.exercices.exercice09Papeterie.model;

import java.util.UUID;

public class Stylo extends ArticleUnitaire{

    private String couleur;


    public Stylo(UUID reference, String nom, double pu, String couleur) {
        super(reference, nom, pu);
        this.couleur = couleur;
    }


    @Override
    public String toString() {
        return super.toString() + " couleur : " + couleur;
    }
}
