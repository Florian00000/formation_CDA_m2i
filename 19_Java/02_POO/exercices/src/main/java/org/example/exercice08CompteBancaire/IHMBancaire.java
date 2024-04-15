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
            System.out.println("3. Affichez les opérations et le solde");
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
                        Client client = null;
                        String saisie = "";
                        double solde = 0.0;
                        switch (menuCompte){
                            case "1":
                                client = creationClient();
                                System.out.println("Entrez le solde du compte");
                                saisie = scanner.nextLine();
                                solde = Double.parseDouble(saisie);
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
                case "3":
                        System.out.println("=== Menu Opérations ===");
                        if (!listeCompte.isEmpty()) {
                            CompteBancaire compte = choixCompte();
                            String menuOperation = "";
                            do {
                                System.out.println("Choix de l'opération");
                                System.out.println("1. Effectuez un dépot" );
                                System.out.println("2. Effectuez un retrait" );
                                System.out.println("3. Affichez les opérations et le solde");
                                System.out.println("0. Quittez le menu Opérations");
                                menuOperation = scanner.nextLine();
                                String montant = "";
                                switch (menuOperation){
                                    case "1":
                                        System.out.println("Indiquez le montant à déposer");
                                        montant = scanner.nextLine();
                                        Operation depot = new Operation(Statut.DEPOT, Double.parseDouble(montant));
                                        compte.listeOperations.add(depot);
                                        compte.setSolde( compte.getSolde() + Double.parseDouble(montant));
                                        System.out.println("Dépot effectué");
                                        break;
                                    case "2" :
                                        System.out.println("Indiquez le montant à retirer");
                                        montant = scanner.nextLine();
                                        Operation retrait = new Operation(Statut.RETRAIT, Double.parseDouble(montant));
                                        compte.listeOperations.add(retrait);
                                        compte.setSolde( compte.getSolde() - Double.parseDouble(montant));
                                        System.out.println("Retrait effectué");
                                        break;
                                    case "3" :
                                        System.out.println("Solde du compte: " + compte.getSolde());
                                        System.out.println("Liste des opérations");
                                        for (Operation o : compte.getListeOperations()){
                                            System.out.println(o);
                                        }
                                        break;
                                    default:
                                        System.out.println("Erreur de saisie");
                                        break;
                                }
                            } while (!menuOperation.equals("0"));
                        } else {
                            System.out.println("Pas de comptes enregistrés");
                        }
                    break;
                default:

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

    public static CompteBancaire choixCompte() {
        Scanner scanner = new Scanner(System.in);
        String menuChoixCompte = "";

        System.out.println("Liste des comptes bancaires");
            for (int i = 0; i < listeCompte.size(); i++) {
                System.out.print("Compte: " + i + " ");
                System.out.println(listeCompte.get(i));
            }
        System.out.println("Tapez le numéro du compte sur lequel effectuez une opération");

        menuChoixCompte = scanner.nextLine();
        return listeCompte.get(Integer.parseInt(menuChoixCompte));

    }
}
