package org.example.exercices.exercice09Papeterie.model;

import java.util.HashMap;
import java.util.UUID;

public abstract class Article {

    private UUID reference;

    private static HashMap<UUID,Article> bdd = new HashMap<>();


    protected Article(UUID reference){
        this.reference = reference;
        // Enregistrement en BDD
        bdd.put(reference,this);
    }

    public UUID getReference() {
        return reference;
    }


    public static int nbArticleBDD(){
        return bdd.size();
    }

    public static Article getArticle(UUID ref){
        return bdd.get(ref);
    }

    public abstract double getPU();

    public abstract String getName();

    @Override
    public String toString() {
        return "Article : " +
                "reference = " + reference;

    }
}
