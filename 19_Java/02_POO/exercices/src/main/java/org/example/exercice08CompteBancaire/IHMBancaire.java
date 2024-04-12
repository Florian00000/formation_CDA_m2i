package org.example.exercice08CompteBancaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHMBancaire {
    private static List <CompteBancaire> listeCompte = new ArrayList<CompteBancaire>();

    public static void menuPrincipal(){
        String menu = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("====Menu Principal====");
            System.out.println("1. Lister les comptes bancaires");
            System.out.println("2. Créer un compte bancaire");
            System.out.println("3. Effectuez un dépôt");
            System.out.println("4. Effectuez un retrait");
            System.out.println("5. Affichez les opérations et le solde");
            System.out.println("0. Quittez le programme");

            menu = scanner.nextLine();
            switch (menu){
                case "1":
                    System.out.println("Liste des comptes bancaires");
                    for(CompteBancaire c : listeCompte){
                        System.out.println(c);
                    }
                    break;
                case "2":
                    String menuCompte = "";
                    do {
                        System.out.println("=== Création de Compte ===");
                        System.out.println("1. Créer un compte courant");
                        System.out.println("2. Créer un compte épargne");
                        System.out.println("3. Créer un compte payant");
                        System.out.println("0. Annuler la création de compte");
                        menuCompte = scanner.nextLine();
                        switch (menuCompte){
                            case "1":
                                Client client = creationClient();
                                System.out.println("Entrez le solde du compte");
                                String saisie = scanner.nextLine();
                                double solde = Double.parseDouble(saisie);
                                CompteCourant compteCourant = new CompteCourant(solde, client);
                                listeCompte.add(compteCourant);
                                break;
                            case "2":
                                client = creationClient();
                                System.out.println("Entrez le solde du compte");
                                saisie = scanner.nextLine();
                                solde = Double.parseDouble(saisie);
                                CompteEpargne compteEpargne = new CompteEpargne(solde, client);
                                listeCompte.add(compteEpargne);
                                break;
                            case "3":
                                client = creationClient();
                                System.out.println("Entrez le solde du compte");
                                saisie = scanner.nextLine();
                                solde = Double.parseDouble(saisie);
                                ComptePayant comptePayant = new ComptePayant(solde, client);
                                listeCompte.add(comptePayant);
                                break;
                            default:
                                System.out.println("Erreur de saisie");
                                break;
                        }
                    }while (!menuCompte.equals("0"));
                    break;
                default:
                    System.out.println("Erreur de saisie");
                    break;
            }

        }while (!menu.equals("0"));

    }

    public static Client creationClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Création du client");
        System.out.println("Entrez le nom du client");
        String nom = scanner.nextLine();
        System.out.println("Entrez le prénom du client");
        String prenom = scanner.nextLine();
        return new Client(nom, prenom);
    }
}
