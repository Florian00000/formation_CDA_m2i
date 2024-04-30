package org.example.exercice04Tp2.Entity;

public abstract class Produit {
    protected String nom;
    protected int prix;

    protected Produit(AbstractProduitBuilder builder){
        this.nom = builder.nom;
        this.prix = builder.prix;
    }
}
