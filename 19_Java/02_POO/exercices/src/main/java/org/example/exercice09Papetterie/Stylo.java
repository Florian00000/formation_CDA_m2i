package org.example.exercice09Papetterie;

public class Stylo extends ArticleUnitaire{
    private String couleur;

    public Stylo(String nom, double prixUnitaire, String couleur) {
        super(nom, prixUnitaire);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return super.toString() +
                " couleur='" + couleur + '\'' +
                '}';
    }
}
