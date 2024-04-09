package org.example.exercice01;

public class Chaise {

    private int pieds;
    private String materiaux;
    private String couleur;

    public Chaise(){
        this(4, "bois", "marron");
    }

    public Chaise(int pieds, String materiaux, String couleur){
        this.pieds = pieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
    }

    public String toString(){
        return "Chaise: pieds = " + this.pieds + " matériaux = " + this.materiaux + " couleur = " + this.couleur;
    }

}
