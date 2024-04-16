package org.example.exercices.exercice08Banque;

import org.example.exercices.exercice08Banque.model.Client;
import org.example.exercices.exercice08Banque.model.CompteCourant;
import org.example.exercices.exercice08Banque.model.CompteEpargne;
import org.example.exercices.exercice08Banque.model.ComptePayant;

public class Main {
    public static void main(String[] args) {

        IHMConsole.start();
        // Création du client
        Client client = new Client("Dupont","Benoit","0123456789");
       // Client client1 = new Client("Dupont","Benoit","0123456789");
        System.out.println(client);
      //  System.out.println(client1);
        System.out.println();


        System.out.println("############  Test Compte courant ############### ");
        CompteCourant compteCourant = new CompteCourant(client);
        client.getCompteBancaireList().add(compteCourant);
        System.out.println(compteCourant);
        compteCourant.depot(100);
        System.out.println();
        System.out.println(compteCourant);
        System.out.println("Essai de retrait de 200 euro (solde insuffisant)");
        compteCourant.retrait(200);
        System.out.println();
        System.out.println(compteCourant);
        System.out.println("Essai de retrait de 25 euro");
        compteCourant.retrait(25);
        System.out.println(compteCourant);
        System.out.println();


        System.out.println("############  Test Compte Payant ############### ");
        ComptePayant comptePayant = new ComptePayant(client);
        client.getCompteBancaireList().add(comptePayant);
        System.out.println(comptePayant);
        comptePayant.depot(100);
        System.out.println();
        System.out.println(comptePayant);
        System.out.println("Essai de retrait de 200 euro (solde insuffisant)");
        comptePayant.retrait(200);
        System.out.println();
        System.out.println(comptePayant);
        System.out.println("Essai de retrait de 25 euro");
        comptePayant.retrait(25);
        System.out.println(comptePayant);
        System.out.println();

        System.out.println("############  Test Compte Epargne ############### ");
        CompteEpargne compteEpargne = new CompteEpargne(client,20);
        client.getCompteBancaireList().add(compteEpargne);
        compteEpargne.depot(100);
        System.out.println(compteEpargne);
        System.out.println();
        compteEpargne.calculerLesInterets(10);
        System.out.println(compteEpargne);




    }
}
