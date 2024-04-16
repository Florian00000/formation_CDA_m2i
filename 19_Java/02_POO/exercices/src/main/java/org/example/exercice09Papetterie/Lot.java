package org.example.exercice09Papetterie;

import java.text.DecimalFormat;

public class Lot extends Article {
    private ArticleUnitaire informations;
    private int quantitee;
    private double remise;

    public Lot(ArticleUnitaire informations, int quantitee, double remise) {
        this.informations = informations;
        this.quantitee = quantitee;
        this.remise = remise;
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return super.toString() +
                " informations = " + informations +
                ", quantitee = " + quantitee +
                ", remise = " + remise + "% " +
                ", prix = " + format.format(
                informations.getPrixUnitaire() * quantitee -
                        (informations.getPrixUnitaire() * quantitee * (remise / 100))) +
                "€ " +
                '}';
    }

    @Override
    public double getPrix() {
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.parseDouble(
                format.format(
                        informations.getPrixUnitaire() * quantitee -
                                (informations.getPrixUnitaire() * quantitee * (remise / 100))));
    }
}
