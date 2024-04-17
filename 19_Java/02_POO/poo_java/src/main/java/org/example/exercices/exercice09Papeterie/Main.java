package org.example.exercices.exercice09Papeterie;

import org.example.exercices.exercice09Papeterie.model.*;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("TP Papeterie");

        Stylo stylo = new Stylo(UUID.randomUUID(),"stylo 1",2,"rouge");
        System.out.println(stylo);
        System.out.println("Taille BDD : "+ Article.nbArticleBDD());
        Ramette ramette= new Ramette(UUID.randomUUID(),"ramette 1",50,25);
        System.out.println(ramette);
        System.out.println("Taille BDD : "+ Article.nbArticleBDD());
        Lot lot = new Lot(UUID.randomUUID(),ramette.getReference(),40,20);
        System.out.println(lot);
        System.out.println("Taille BDD : "+ Article.nbArticleBDD());

        Facture facture = new Facture("Toto","17/04/2024",2);
        facture.ajouterLigne(stylo.getReference(),10);
        facture.ajouterLigne(ramette.getReference(),7);

        System.out.println();
        System.out.println("Affichage de la facture pour 10 stylo et 7 ramette :");
        System.out.println();
        System.out.println(facture);

    }
}
