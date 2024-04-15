package org.example.demos.demo04Interface.model;

public class Rectangle extends Forme{

    private double longueur;
    private double largeur;

    public Rectangle(String nom, double longueur, double largeur) {
        super(nom);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double calculerAire(){
        return longueur * largeur;
    }

    @Override
    public double calculerPerimetre(){
        return 2 * (longueur + largeur);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                ", nom='" + nom + '\'' +
                '}';
    }
}
