package org.example.exercice09Papetterie;

import java.time.LocalDate;

public class Facture {
    private int numeroFacture;
    private static int idFacture = 0;
    private  Ligne[] listLignes;

    private String client;
    private LocalDate date = LocalDate.now();

    public Facture(String client) {
        this(client, 10);
    }

    public Facture(String client, int nbLignesAchats) {
        this.numeroFacture = idFacture++;
        this.client = client;
        this.listLignes = new Ligne[nbLignesAchats];
    }

    //TODO Faire la fonction ajouter lignes et créer une classe Ligne
    public void ajouterLigne(Integer refArticle , int nbArticles){
        Article article = Papeterie.getListeArticles().get(refArticle);
        System.out.println(article);
        boolean ajout = false;
        for (int i = 0; i < listLignes.length; i++) {
            if (listLignes[i] == null) {
                listLignes[i] = new Ligne(article, nbArticles);
                ajout = true;
                break;
            }

        }
        if (ajout){
            System.out.println("ajout réussi");
        }else {
            System.out.println("Plus de place sur la facture");
        }

        // TODO affichage test à enlever ensuite
        for (Ligne l: listLignes){
            if (l != null){
                System.out.println(l.afficherLigne());
            }
        }

    }
}
