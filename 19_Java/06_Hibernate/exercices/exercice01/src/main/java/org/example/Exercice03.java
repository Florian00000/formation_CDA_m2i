package org.example;

import org.example.entities.Produit;
import org.example.service.ProduitService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Exercice03 {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

        //1
        System.out.println("Afficher la liste des produits commandés entre deux dates lus au clavier.\n");
        try {
            List<Produit> produits1 = ps.findAllBetweenTwoDates();
            for (Produit p : produits1) {
                System.out.println(p);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //2
        System.out.println("retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.");
        System.out.println("Entrer la valeur du stock");
        Scanner sc = new Scanner(System.in);
        int stock = sc.nextInt();
        sc.nextLine();

        try {
            List<Produit> produits = ps.findAllByStockBelow(stock);
            for (Produit p : produits) {
                System.out.println(p);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ps.close();
    }
}
