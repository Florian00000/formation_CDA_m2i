package org.example.exercices.exercice01Chaise;

public class Chaise {
//    private final int nombrePieds = 4; // la variable devient non modifiable dans tous les cas
    private final int nombrePieds; // la variable devient non modifiable sauf dans le constructeur
    private String couleur;
    private float prix;
    private String type;

    public Chaise() {
        this(4, "blanche", 8.0f, "plastique");
    }

    public Chaise(int nombrePieds, String couleur, float prix, String type) {
        this.nombrePieds = nombrePieds;
        this.couleur = couleur;
        this.prix = prix;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec " + this.nombrePieds + " pied(s) en " + this.type
                + " de couleur " + this.couleur + " à un prix de " + this.prix + " euros";
    }
}
