package org.example.exercices.exercice09Papeterie.model;

import java.util.UUID;

public class Ramette extends ArticleUnitaire{

    private int grammage;


    public Ramette(UUID reference, String nom, double pu, int grammage) {
        super(reference, nom, pu);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return super.toString() + " grammage : " + grammage;
    }
}
