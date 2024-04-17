package org.example.exercices.exercice09Papeterie.model;

import java.util.UUID;

public class Lot extends Article{

    private Article article;

    private int nb, pourcentage;

    public Lot(UUID reference,UUID referenceArticle, int nb, int pourcentage) {
        super(reference);
        this.nb = nb;
        this.pourcentage = pourcentage;
        this.article = Article.getArticle(referenceArticle);
    }

    @Override
    public double getPU() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " contient : " + article.toString() + " en quantité de : " + nb + " avec une réduction de : " + pourcentage + " %.";
    }
}
