package org.example.exercice09Papetterie;

public abstract class ArticleUnitaire extends Article {
    private String nom;
    private double prixUnitaire;

    public ArticleUnitaire(String nom, double prixUnitaire) {
        super();
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName() +
                " nom=' " + nom + '\'' +
                ", prixUnitaire= " + prixUnitaire ;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public double getPrix(){
        return prixUnitaire;
    }
}
