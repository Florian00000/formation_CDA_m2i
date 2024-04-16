package org.example.exercice09Papetterie;

public class Main {
    public static void main(String[] args) {



        Article stylo1 = new Stylo("superStylo", 5.25, "bleue");
        Article ramette1 = new Ramette("une ramette quoi", 8, 5);

        Article lot1 = new Lot((ArticleUnitaire) stylo1, 5, 5.5);

        //J'ajoute les articles à la "BDD"
        Papeterie.setListeArticles(stylo1.getReference(), stylo1);
        Papeterie.setListeArticles(ramette1.getReference(), ramette1);

        Papeterie.setListeArticles(lot1.getReference(), lot1);

        System.out.println(  Papeterie.getListeArticles());

        Facture facture1 = new Facture("Georges");

        facture1.ajouterLigne(0, 1);

    }

}
