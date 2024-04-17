package org.example.exercices.exercice09Papeterie.model;

public class Ligne {

    private Article article;

    private int quantite;

    public Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public double prixTotal(){
        return article.getPU() * quantite;
    }

    public String afficheLigne(){
        return quantite + " - " + article.getReference() + " - "+ article.getName()+ " - " + article.getPU() + " - " + prixTotal();
    }

    @Override
    public String toString() {
        return quantite + " " + article;
    }
}
