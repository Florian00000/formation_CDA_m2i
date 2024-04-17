package org.example.exercice09Papetterie;

public class Ligne {
    private Article article;
    private int nbArticles;

    public Ligne(Article article, int nbArticles) {
        this.article = article;
        this.nbArticles = nbArticles;
    }




    public String toString() {
        return "Ligne{" +
                "article=" + article +
                ", nbArticles=" + nbArticles +
                '}';
    }
}
