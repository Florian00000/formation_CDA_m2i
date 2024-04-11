package org.example.exercices.exercice06Pendu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IHM {
    private static Pendu pendu; // la partie en cours pour notre IHM
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("=== Paramètres de partie ===\n");
        System.out.print("Voulez-vous un nombre d'essais spécifique (10 par défaut) ? y/N ");
        if (scanner.nextLine().equalsIgnoreCase("y")){
//            System.out.print("Combien voulez-vous d'essais ? ");
//            int nbEssais = scanner.nextInt(); // erreur si saisie d'autre chose qu'un entier
//            scanner.nextLine(); // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo

            // Contrôle de saisie sur un entier (un ENTIER et POSITIF)
            int nbEssais;
            while (true){
                System.out.print("Combien voulez-vous d'essais ? ");
                try {
                    nbEssais = Integer.parseInt(scanner.nextLine()); // Parse = conversion de chaine vers un autre type (ici int)
                    if(nbEssais<0){
//                        System.out.print("Saisie incorrecte ! (négatif) ");
//                        continue;
                        throw new Exception("nbEssais n'est pas positif.");
                    }
                } catch (NumberFormatException e){
                    System.out.print("Saisie incorrecte ! (pas un entier) ");
                    continue;
                } catch (Exception e) {
                    System.out.print("Saisie incorrecte ! (négatif) ");
                    continue;
                }
                break;
            }

            pendu = new Pendu(nbEssais);
        }
        else{
            pendu = new Pendu();
        }

        System.out.println("Jeu du pendu généré ! Nombre d'essais : " + pendu.getNbEssaisTotal());

        boolean win;
        do {
            win = jouerUnTour();
            System.out.println("--------------------------------");
        } while (!win && pendu.getNbEssaisRestants() != 0);

        System.out.println(win ?  "C'est Gagné, bravo !!!" : "C'est Perdu, dommage...");
    }

    private static boolean jouerUnTour(){ // cette fonction permet de jouer UN tour, elle renvoie true si l'utilisateur a gagné et que la partie est finie
        System.out.println("Le mot à trouver : " + pendu.getMasque());
        System.out.println("Il vous reste " + pendu.getNbEssaisRestants() + " essais");

        System.out.print("Veuillez saisir une lettre : ");

        // Contrôle de saisie (un seul caractère compris entre A et Z)
        String saisieLettre = scanner.nextLine();
        while (!Pattern.matches("[A-Za-z]", saisieLettre)) {
            System.out.print("Saisie incorrecte ! Veuillez saisir une lettre : ");
            saisieLettre = scanner.nextLine();
        }

        char lettre = saisieLettre.toLowerCase().charAt(0);

        String messageTestChar = pendu.testChar(lettre);
        System.out.println(messageTestChar);

//        pendu.genererMasque();

        affichagePendu(pendu.getNbEssaisTotal() - pendu.getNbEssaisRestants(), pendu.getNbEssaisTotal());

        return pendu.testWin();
    }

    public static void affichagePendu(int noEssai, int nbEssaiMax)
    {
        String[][] penduAscii = {
                {"           ",
                        "            ",
                        "            ",
                        "            ",
                        "            ",
                        "            ",
                        "            "},
                {"           ",
                        "            ",
                        "            ",
                        "            ",
                        "            ",
                        "            ",
                        "--------    "},
                {"           ",
                        "            ",
                        "            ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"           ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"           ",
                        " |/         ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"_____      ",
                        " |/         ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"___________",
                        " |/         ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"___________ ",
                        " |/       | ",
                        " |          ",
                        " |          ",
                        " |          ",
                        " |          ",
                        "--------    "},
                {"___________ ",
                        " |/       | ",
                        " |        O ",
                        " |       /|\\",
                        " |       / \\",
                        " |          ",
                        "--------    "},
        };
        int noPendu = noEssai == 0 ? 0 : (noEssai * 8 / nbEssaiMax);
        for (int i = 0; i < 7; i++)
        {
            System.out.println(penduAscii[noPendu][i]);
        }
    }
}
