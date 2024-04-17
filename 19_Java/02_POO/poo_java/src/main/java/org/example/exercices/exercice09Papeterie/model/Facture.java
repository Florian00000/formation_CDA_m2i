package org.example.exercices.exercice09Papeterie.model;

import java.util.Arrays;
import java.util.UUID;

public class Facture {

    private static int NB_MAX_LIGNES = 10;

    private static int numeroCourant = 0;

    private int idFacture;

    private String client, date;

    private Ligne[] lignes;

    private int nbLignes;

    private int numero = 0;


    public Facture(String client, String date, int nbLignes) {
        this.client = client;
        this.date = date;
        this.nbLignes = nbLignes;
        this.lignes = new Ligne[nbLignes];
        this.idFacture = ++numeroCourant;
    }

    public Facture(String client, String date) {
        this(client,date,NB_MAX_LIGNES);
    }


    public void ajouterLigne(UUID referenceArticle,int quantite){
        lignes[numero++] = new Ligne(Article.getArticle(referenceArticle),quantite);
    }

    public double getPrixTotal(){
        double pt = 0;
        for (int i = 0; i < nbLignes ; i++){
            pt += lignes[i].prixTotal();
        }
        return pt;
    }

    @Override
    public String toString() {

        String message = "Facture n°"+ idFacture +"  pour le client '" + client + '\'' +
                ", date  : '" + date + '\'' +
                ", nbLignes=" + nbLignes ;

        for (int i = 0; i < nbLignes ; i++){
            message += "\n"+ lignes[i].afficheLigne();
        }
        message += "\n Prix total de la facture : " + getPrixTotal();
        return message;
    }
}
