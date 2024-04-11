package org.example.exercice07Plante;

public class Arbre extends Plante {

    private double cicrconferenceTronc;

    public Arbre(String nom, double hauteur, String couleurFeuilles, double cicrconferenceTronc) {
        super(nom, hauteur, couleurFeuilles);
        this.cicrconferenceTronc = cicrconferenceTronc;
    }

    @Override
    public String toString() {
        return super.toString() +
                " cicrconferenceTronc=" + cicrconferenceTronc +
                '}';
    }
}
