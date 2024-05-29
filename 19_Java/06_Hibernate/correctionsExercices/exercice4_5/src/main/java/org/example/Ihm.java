package org.example;

import org.example.entity.Produit;
import org.example.service.ProduitService;

import java.util.List;
import java.util.Scanner;

public class Ihm {

    private ProduitService produitService;
    private Scanner scanner;

    public Ihm(){
        scanner = new Scanner(System.in);
        produitService = new ProduitService();
    }

    public void start(){
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice){
                case "1" -> valeurParMarque();
                case "2" -> moyenne();
                case "3" -> produitsParMarque();
                case "4" -> deleteParMarque();
                case "5" -> ajouterImage();
                case "6" -> ajouterCommentaire();
                case "7" -> afficherProduitsAvecNote();
                default -> System.out.println("choix invalide");
            }

        }while (!choice.equals("0"));
        // Sortie du menu et fin du programme
        produitService.close();
    }

    private void menu(){
        System.out.println("#######  Menu  ######");
        // Exercice 4
       // 1. Afficher la valeur du stock des produits d'une marque choisie.
        System.out.println("1. Afficher la valeur du stock des produits d'une marque choisie.");
       // 2. Calculer le prix moyen des produits.
        System.out.println("2. Calculer le prix moyen des produits.");
       // 3. Récupérer la liste des produits d'une marque choisie.
        System.out.println("3. Récupérer la liste des produits d'une marque choisie.");
       // 4. Supprimer les produits d'une marque choisie de la table produit.
        System.out.println("4. Supprimer les produits d'une marque choisie de la table produit.");
        // Exercice 5
       // 1. Ajouter les classes nécessaires.
       // 2. Ajouter la possibilité d'ajouter une image à un produit.
        System.out.println("5. Ajouter une image à un produit.");
       // 3. Ajouter la possibilité d'ajouter un commentaire à un produit.
        System.out.println("6. Ajouter un commentaire à un produit.");
       // 4. Afficher les produits ave une note de 4 ou plus.
        System.out.println("7. Afficher les produits ave une note min.");
    }

    private void valeurParMarque(){
        System.out.println("Afficher la valeur du stock des produits d'une marque choisie.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        double valeur = produitService.valeurStockParMarque(marque);
        System.out.println("La valeur du stock pour la marque : "+marque+" est de : "+valeur);

    }

    private void moyenne(){
        System.out.println("Calculer le prix moyen des produits.");
        System.out.println("Le prix moyen des produits est de "+produitService.moyenne());
    }

    private void produitsParMarque(){
        System.out.println("Récupérer la liste des produits d'une marque choisie.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        List<Produit> produitList = produitService.filterByMarque(marque);
        for (Produit p: produitList){
            System.out.println(p);
        }
    }

    private void deleteParMarque(){
        System.out.println("Supprimer les produits d'une marque choisie de la table produit.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        if(produitService.deleteByMarque(marque)){
            System.out.println("Suppression ok");
        }else {
            System.out.println("Suppression nok");
        }
    }

    private void ajouterImage(){
        System.out.println("Ajouter une image à un produit.");
        // on vas chercher l'id du produit
        System.out.println("Merci de saisir l'id du produit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir l'url de l'image");
        String url = scanner.nextLine();

    }

    private void ajouterCommentaire(){
        System.out.println("Ajouter un commentaire à un produit.");
        System.out.println("Merci de saisir l'id du produit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir le contenu du commentaire");
        String content = scanner.nextLine();
    }

    private void afficherProduitsAvecNote(){
        System.out.println("Afficher les produits ave une note min.");
        System.out.println("Merci de saisir la note min :");
        int id = scanner.nextInt();
        scanner.nextLine();
    }


}
