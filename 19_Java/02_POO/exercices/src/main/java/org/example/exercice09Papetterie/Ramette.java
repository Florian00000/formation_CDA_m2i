package org.example.exercice09Papetterie;

public class Ramette extends ArticleUnitaire {
    private double grammage;

    public Ramette(String nom, double prixUnitaire, double grammage) {
        super(nom, prixUnitaire);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return super.toString() +
                " grammage=" + grammage +
                '}';
    }
}
