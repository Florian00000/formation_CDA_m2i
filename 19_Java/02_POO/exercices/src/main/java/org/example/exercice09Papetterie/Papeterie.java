package org.example.exercice09Papetterie;

import java.util.HashMap;

public class Papeterie {
    private static HashMap <Integer, Article> listeArticles = new HashMap<>();

    public static HashMap<Integer, Article> getListeArticles() {
        return listeArticles;
    }

    public static void setListeArticles(int refArticle, Article article) {
        listeArticles.put(refArticle, article);
    }
}
