package org.example.exercice09Papetterie;

public abstract class Article {
    private int reference;
    private static int idRef = 0;

    public Article() {
        this.reference = idRef++;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {reference= " + reference ;
    }

    public int getReference() {
        return reference;
    }

    public abstract double getPrix();
}
