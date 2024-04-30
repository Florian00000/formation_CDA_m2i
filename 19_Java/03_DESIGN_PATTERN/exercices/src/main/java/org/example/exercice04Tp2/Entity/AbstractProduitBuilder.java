package org.example.exercice04Tp2.Entity;

public abstract class AbstractProduitBuilder {
    protected String nom;
    protected int prix;

    public AbstractProduitBuilder nom (String nom) {
        this.nom = nom;
        return this;
    }

    public AbstractProduitBuilder prix (int prix) {
        this.prix = prix;
        return this;
    }

    public abstract Produit build();

}
