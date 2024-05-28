package org.example;

import org.example.entities.Produit;
import org.example.service.ProduitService;

import java.util.Date;
import java.util.List;

public class Exercice03 {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

        //1
        System.out.println("Afficher la liste des produits commandés entre deux dates lus au clavier.\n");
        List<Produit> produits3 = ps.findAllBetweenTwoDates();
        for (Produit p : produits3) {
            System.out.println(p);
        }

        ps.close();
    }
}
