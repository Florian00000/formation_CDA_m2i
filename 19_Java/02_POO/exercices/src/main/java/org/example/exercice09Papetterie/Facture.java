package org.example.exercice09Papetterie;

import java.time.LocalDate;

public class Facture {
    private int numeroFacture;
    private static int idFacture = 0;
    private  Article[] lignes ;

    private String client;
    private LocalDate date = LocalDate.now();

    public Facture(String client) {
        this(client, 10);
    }

    public Facture(String client, int nbLignesAchats) {
        this.numeroFacture = idFacture++;
        this.client = client;
        this.lignes = new Article[nbLignesAchats];
    }

    //TODO Faire la fonction ajouter lignes et créer une classe Ligne
    public void ajouterLigne(Integer refArticle , int nbArticles){
        Article article = Papeterie.getListeArticles().get(refArticle);
        System.out.println(article);
        boolean ajout = false;
        for (int i = 0; i < lignes.length; i++) {
            if (lignes[i] != null) {
                lignes[i] = article;
                ajout = true;
                break;
            }

        }
        if (ajout){
            System.out.println("ajout réussi");
        }else {
            System.out.println("Plus de place sur la facture");
        }

        for (Article a: lignes){
            System.out.println(a);
        }

    }
}
