package org.example;

import org.example.entities.Produit;
import org.example.service.ProduitService;

import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.List;

public class Exercice02 {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

        //1
        System.out.println("Afficher la totalité des produits");
        List<Produit> produits = ps.findAll();
        for (Produit p : produits) {
            System.out.println(p);
        }

        //2
        System.out.println("Afficher la liste des produits dont le prix est supérieur à 100 euros");
        List<Produit> produits2 = ps.findAllMoreExpensiveThan(100);
        for (Produit p : produits2) {
            System.out.println(p);
        }

        //3
        System.out.println("Afficher la liste des produits achetés entre deux dates.");
        List<Produit> produits3 = ps.findAllBetweenTwoDates(new Date("2019/01/01"), new Date("2023/01/01"));
        for (Produit p : produits3) {
            System.out.println(p);
        }

        ps.close();
    }
}
