package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class exercices_tableau {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Exercice Recherche de Valeur

        /*
        int[] tabInt = { 25, 5 , 7, 36};

        while (true) {
            System.out.println("Entrez un entier");
            int entier = scanner.nextInt();
            boolean presenceTab= false;
            int emplacement = 0;

            for (int i = 0; i < tabInt.length; i++){
                if (tabInt[i] == entier) {
                    presenceTab = true;
                    emplacement = i;
                }

            }
            if (presenceTab){
                System.out.println("La valeur est bien présente dans le tableau à l'emplacement " + emplacement);
            }else {
                System.out.println("La valeur n'est pas présente dans le tableau");
            }
        }



        //Simulation réservation sièges




        boolean [][] placeTheatre = new boolean[5][5];
//        for (boolean[] rangee : placeTheatre){
//            System.out.println("rangée");
//            for(boolean placePrise: rangee) {
//                String disponibilte = "prise";
//                if (!placePrise) {
//                    disponibilte = "disponible";
//                }
//                System.out.println("place: " + disponibilte );
//            }
//        }




        //affichage  place dispo
        for (int i = 0; i < placeTheatre.length; i++) {
            System.out.println("rangée: " + i);
            for (int j = 0; j < placeTheatre[i].length; j++) {
                String disponibilte = "prise";
                if (!placeTheatre[i][j]) {
                    disponibilte = "disponible";
                }
                System.out.println("place " + j + ": " + disponibilte );
            }
        }

        System.out.println("Indiquez la place que vous désirez, en commencant par la rangée");
        int rangee = scanner.nextInt();
        System.out.println("Puis le numéro de la place");
        int place = scanner.nextInt();

        placeTheatre[rangee][place] = true;

        //réponse
        for (int i = 0; i < placeTheatre.length; i++) {
            System.out.println("rangée: " + i);
            for (int j = 0; j < placeTheatre[i].length; j++) {
                String disponibilte = "prise";
                if (!placeTheatre[i][j]) {
                    disponibilte = "disponible";
                }
                System.out.println("place " + j + ": " + disponibilte );
            }
        }


        //Gestion d'inventaire

        String[] nomArticles = { "yaourts", "baby-foot", "maillots", "bonnets"};
        int[] nbArticles= {50, 3, 25, 10};



         while (true) {
             int interaction;
             System.out.println("Voulez vous ajoutez (1), retirer (2) ou consultez (3) les articles");
             interaction = scanner.nextInt();
             scanner.nextLine();

             switch (interaction) {
                 case 1:
                     System.out.println("Quel articles souhaitez vous ajoutez?");
                     String choix = scanner.nextLine().toLowerCase();
                     int index = -1;
                     for (int i = 0; i < nomArticles.length; i++) {
                         if (nomArticles[i].equals(choix)){
                            index = i;
                         }

                     }
                     if (index >= 0) {
                         System.out.println("Combiens de " + choix  + " souhaitez vous ajouter?");
                         int ajout = scanner.nextInt();
                         nbArticles[index] = nbArticles[index] + ajout;
                         System.out.println("Ajout Confirmé");
                     }else {
                         System.out.println("pas de " + choix +  " trouvé");
                     }

                     break;
                 case 2:
                     System.out.println("Quel articles souhaitez vous retirer?");
                     choix = scanner.nextLine().toLowerCase();
                     index = -1;
                     for (int i = 0; i < nomArticles.length; i++) {
                         if (nomArticles[i].equals(choix)){
                             index = i;
                         }

                     }
                     if (index >= 0) {
                         System.out.println("Combiens de " + choix  + " souhaitez vous retirer?");
                         int retrait = scanner.nextInt();
                         nbArticles[index] = nbArticles[index] - retrait;
                         System.out.println("Prélèvement Confirmé");
                     }else {
                         System.out.println("pas de " + choix +  " trouvé");
                     }

                     break;
                 case 3:
                     for (int i = 0; i < nomArticles.length; i++) {
                         System.out.println(nomArticles[i] + ": " + nbArticles[i]);
                     }
                     break;
             }
         }

         */

        //exercice batialle navale

        int[][] batailleNavale = new int[12][12];
        String[] affichageLettre = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        Boolean victoire = false;

        while (!victoire){

            System.out.println("   1  2  3  4  5  6  7  8  9  10 11 12");
            for (int i = 0; i < batailleNavale.length; i++) {
                String messageAffiche = "";
                messageAffiche = messageAffiche + affichageLettre[i] + "  ";
                for (int j = 0; j < batailleNavale.length; j++) {
                    messageAffiche = messageAffiche + batailleNavale[i][j] + "  ";

                }

                System.out.println(messageAffiche);
            }

            String lettre = "";
            do {
                System.out.println("\n Quelle lettre souhaitez vous attaquer");
                lettre = scanner.nextLine().toUpperCase();
            } while (!lettre.equals("A") && !lettre.equals("B") && !lettre.equals("C") && !lettre.equals("D") && !lettre.equals("E") && !lettre.equals("F") && !lettre.equals("G") && !lettre.equals("H") && !lettre.equals("I") && !lettre.equals("J") && !lettre.equals("K") && !lettre.equals("L"));

            int chiffre = 0;
            do {
                System.out.println("Quelle chiffre souhaitez vous attaquer");
                chiffre = scanner.nextInt();
            } while (chiffre <= 0 || chiffre >= 13 );



            System.out.println(lettre + chiffre);
            scanner.nextLine();

        }







    }
}