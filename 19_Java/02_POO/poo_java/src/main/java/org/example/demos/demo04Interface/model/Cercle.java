package org.example.demos.demo04Interface.model;

public class Cercle extends Forme{

    private double rayon;
    public Cercle(String nom, double rayon) {
        super(nom);
        this.rayon = rayon;
    }

    @Override
    public double calculerAire(){
       return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre(){
        return 2 * Math.PI * rayon;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "rayon=" + rayon +
                ", nom='" + nom + '\'' +
                '}';
    }
}
