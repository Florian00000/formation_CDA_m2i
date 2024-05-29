package org.example;

import org.example.entities.Produit;
import org.example.service.ProduitService;

import java.util.List;
import java.util.Scanner;

public class Exercice04 {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

        //1
        System.out.println("Afficher la valeur du stock des produits d'une marque choisie.");
        System.out.println("Entrez le nom de la marque");
        Scanner sc = new Scanner(System.in);
        String nomMarque = sc.nextLine();
        Double valeurStock = ps.getPriceOfStockByBrand(nomMarque);
        System.out.println("Valeur du stock = " + valeurStock);


        //2
        System.out.println("Calculer le prix moyen des produits.");
        Double prixMoyen = ps.getAveragePrice();
        System.out.println("prixMoyen des produits = " + prixMoyen + "€");

        //3
        System.out.println("Récupérer la liste des produits d'une marque choisie.");
        System.out.println("Entrez le nom de la marque");
        nomMarque = sc.nextLine();
        List<Produit> produits = ps.filterByBrand(nomMarque);
        for (Produit p : produits) {
            System.out.println(p);
        }

        //4
        System.out.println("Supprimer les produits d'une marque choisie de la table produit.");
        System.out.println("Entrez le nom de la marque");
        nomMarque = sc.nextLine();
        String question4 = ps.deleteByBrand(nomMarque);
        System.out.println(question4);

        sc.close();
        ps.close();
    }
}
