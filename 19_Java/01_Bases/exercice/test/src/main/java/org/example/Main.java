package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        /*System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        int age ;
        age = 36;
        System.out.println(age);
        var firstname = "florian";
        System.out.println(firstname);
        boolean test = true;
        System.out.println(test);
        float prix = 10.99F;
        System.out.println(prix);
        double solde = 100_100.97;
        System.out.println(solde);


        //lire à partir de l'écran => JSE => Scanner
        Scanner scanner = new Scanner(System.in);

        String saisi = scanner.nextLine();
        System.out.println(saisi);
        int saisiInt = scanner.nextInt();
        System.out.println(saisiInt);
        float saisiFloat = scanner.nextFloat();
        System.out.println(saisiFloat);
        */

        //lire à partir de l'écran => JSE => Scanner
        Scanner scanner = new Scanner(System.in);

        //Exercice 1

        /*System.out.println("Exercice 1");
        System.out.println("Entrez la température");
        float tempature = scanner.nextFloat();
        System.out.println("Indiquez si il s'agit de Celsius (true) ou de Fahrenheit (false)");
        boolean mesure = scanner.nextBoolean();
        if (mesure ) {
            tempature = tempature * 9 / 5 + 32;
            System.out.println(tempature + "Fahrenheit");
        } else {
            tempature = (tempature - 32) * 5 / 9;
            System.out.println(tempature + "Celsius");
        };



        //Exercice 2

        System.out.println("Exercice 2");
        System.out.println("Entrez le nombre de bonbons à acheter");
        int nbBonbons = scanner.nextInt();
        System.out.println("Entrez le prix des bonbons");
        float prixBonbons = scanner.nextFloat();
        float prixTotal = nbBonbons * prixBonbons ;
        System.out.println(prixTotal + " euros");



        //Exercice 3
        System.out.println("Exercice 3");
        System.out.println("Entrez un premier message");
        String messageA = scanner.nextLine();
        LocalDateTime timeA = LocalDateTime.now();
        //long debutTemps = System.currentTimeMillis();
        System.out.println("Entrez un second message");
        String messageB = scanner.nextLine();
        LocalDateTime timeB = LocalDateTime.now();
        //long finTemps = System.currentTimeMillis();

        Duration time = Duration.between(timeA, timeB);
        long response = time.getSeconds();
        //long tempsEcoule = finTemps - debutTemps;
        //double tempsEcouleEnSeconde = tempsEcoule : 1000.0;

        System.out.println("Il s'est écoulé " +  response + " secondes entre les deux messages");
         */

        //Structure conditionneles
        // => if else;
        /*int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("Majeur");
        }else {
            System.out.println("mineur");
        }

        if ( age >8 && age <= 11){
            System.out.println("Poussin");
        } else if (age >11 && age <= 13) {
            System.out.println("Benjamin");
        } else if (age > 15 && age <= 17) {
            System.out.println("cadet");
        } else {
            System.out.println("les autres");
        }

        int numeroMois = scanner.nextInt();
        switch (numeroMois) {
            case 1:
                System.out.println("Janvier");
                break;
            case 2:
                System.out.println("Février");
                break;
            case 3:
                System.out.println("Mars");
                break;

            default:
                System.out.println("Default value");
                break;
        }

         */

        /*
        //Exercices Structures conditionnelles


        //Exercice 1
        System.out.println("Il était une fois, un ouvrier qui arrive le matin devant la machine à café, l'ouvrier vas t'il prendre une café(1), un chocolat chaud (2) ou une soupe? (3)");
        int reponse = scanner.nextInt();

        switch (reponse) {
            case 1:
                System.out.println("L'ouvrier est en 'pleine forme' pour travailler");
                break;
            case 2:
                System.out.println("L'ouvrier s'endort sur son lieu de travaille");
                break;
            case 3:
                System.out.println("La machine lui sert de l'eau chaude...");
                break;
            default:
                System.out.println("L'ouvrier as t'il oublié sa monnaie?");
                break;
        }

        //Exercice 2
        System.out.println("Est ce que l'animal auquel vous pensez vit dans l'eau? (Répondez par true ou false)");
        boolean animalMarin = scanner.nextBoolean();
        if (animalMarin) {
            System.out.println("S'agit il d'un mamifère");
            boolean mamifere = scanner.nextBoolean();
            if (mamifere) {
                System.out.println("S'agit il d'un dauphin");
                boolean dauphin = scanner.nextBoolean();
                if (!dauphin) {
                    System.out.println("Il s'agit d'une baleine");
                }
            }else {
                System.out.println("Il s'agit donc d'un poisson");
            }
        } else {
            System.out.println("As t'il un portable dans sa poche?");
            boolean portable = scanner.nextBoolean();
            if (portable) {
                System.out.println("Ils s'agit d'un humain");
            } else {
                System.out.println("S' agit il d'un chien?");
                boolean chien = scanner.nextBoolean();
                if (!chien) {
                    System.out.println("Alors ca ne m'intéresse pas");
                }
            }
        }



        //Exercice 3
        System.out.println("Préférez vous la force, la sagesse ou la ruse?");
        String reponseCarac = scanner.nextLine().toLowerCase();
        switch (reponseCarac) {
            case "force":
                System.out.println("Vous êtes Thor car vous pouvez pétez les dents de tout le monde ;), et même ce petit serpent de Jörmungandr");
                break;
            case "intelligence":
                System.out.println("Vous êtes Odin, car vous êtres borgne et avez des corbeaux plutôt utiles");
                break;
            case "ruse":
                System.out.println("Vous êtes Loki, et je vous conseille de changer rapidement");
                break;
            default:
                System.out.println("Vous n'êtes personne, mais au moins vous ne serez pas responsable du Ragnarok");
                break;
        }

        //Exercice 4
        System.out.println("Comment vous sentez vous aujourd'hui? joyeux, fatigué, aventurier");
        String reponseHumeur = scanner.nextLine().toLowerCase();
        switch (reponseHumeur) {
            case "joyeux":
                System.out.println(" Vas te faire une bonne pitance");
                break;
            case "fatigué":
                System.out.println("Vas te coucher");
                break;
            case "aventurier":
                System.out.println("C'est pas dans un algo que tu vas trouver une aventure!");
                break;
            default:
                System.out.println("exercice4");
        }



        //structure itératives
        for (int i = 10; i < 30; i++) {
            System.out.println(i);
        }


        int i = 1;
        while (i < 10) {
            System.out.println(i);
            i++;
        };
        int choix = 0;
        while (true) {
            System.out.println("votre choix: ");
            choix = scanner.nextInt();
            if (choix > 100) {
                break;
            }
        }
        do {
            System.out.println("votre choix: ");
            choix = scanner.nextInt();
        }while (choix <= 100);

         */

        //structure itératives exercice

        //Exercice 1:

        /*
        System.out.println("Devinez le bon nombre (Entre 0 et 100)");
        int nbRandom = (int)(Math.random() * 100 ) ;
        int nbUtilisateur = scanner.nextInt();
         while ( nbRandom != nbUtilisateur ) {
            if (nbUtilisateur < nbRandom) {
                System.out.println("Entrez un nombre plus grand");
            }else {
                System.out.println("Entrez un nombre plus petit");
            }
             nbUtilisateur = scanner.nextInt();
        }
        System.out.println("Bien joué, vous avez trouvé");



         //Exercice 2
        System.out.println("Entrez le nombre de départ");
        int nbDepart = scanner.nextInt();
        System.out.println("Entrez le nombre de fin");
        int nbFin = scanner.nextInt();
        for (int i = nbDepart; i <= nbFin; i++) {
            System.out.println(i);
        }



        //Exercice 3
        System.out.println("Simulation parcours obstacle");
        int caseDepart = 1;
        do {
            int nbAleatoire =  (int)(Math.random() * 100 );
            System.out.println("Entrez la même valeure que le nombre " + nbAleatoire);
            int reponseUtilisateur = scanner.nextInt();
            if ( reponseUtilisateur == nbAleatoire) {
                caseDepart++;
                System.out.println("Bien joué vous avancez d'une case");
            }else {
                caseDepart--;
                System.out.println("Dommage vous reculez d'une case");
            }
        } while ( caseDepart < 5);





        //Exercice 4
        System.out.println("Choisisez un caractère");
        String caractere = scanner.nextLine();
        System.out.println("Entrez le nombre de lignes");
        int nbLignes = scanner.nextInt();
        String espace = " ";
        String ligne = "";
        for (int i = 0; i < nbLignes; i++) {
            String espacement = "";
            for (int j = i; j < nbLignes; j++) {
                espacement = espacement + espace;
            }
            if (i == 0){
                ligne = caractere;
            } else {
                ligne = ligne + caractere + caractere;
            }

            System.out.println(espacement + ligne + espacement);
        }

         */

        // Exercice festival de musique virtuel
        System.out.println("Bienvenu au festival");


        int energie = 10;
        int temps = 500;
        String historique = "";
        do {
            System.out.println("Choisisez un genre musical (Rock, électronique, Jazz, Classique)");
            String genreMusique = scanner.nextLine().toLowerCase();
        switch (genreMusique) {
            case "rock":
                    System.out.println("Programme: ");
                    System.out.println("Pink Floyd / 1h30");
                    System.out.println("Gojira / 1h00");
                    System.out.println("Slayer / 45");
                    String activite = scanner.nextLine().toLowerCase();
                    switch (activite) {
                        case "pink floyd":
                            energie = energie - 2;
                            temps = temps - 90;
                            historique = historique + "Pink Floyd, ";
                            System.out.println("Super concert de Pink Floyd");
                            break;
                        case "gojira":
                            energie = energie - 3;
                            temps = temps - 60;
                            historique = historique + "gojira, ";
                            System.out.println("Super concert de gojira");
                            break;
                        case "slayer":
                            energie = energie - 3;
                            temps = temps - 45;
                            historique = historique + "slayer, ";
                            System.out.println("Super concert de slayer");
                            break;
                        default:
                            System.out.println("Ca n'est pas au programme");
                    }
                    break;
            case "électronique":
                    System.out.println("Programme: ");
                    System.out.println("AFX / 1h30");
                    System.out.println("X&trick / 1h00");
                    System.out.println("DeathMachine / 1h00");
                    System.out.println("Clarck / 45min");
                    activite = scanner.nextLine().toLowerCase();
                    switch (activite) {
                        case "afx":
                            energie = energie - 2;
                            temps = temps - 90;
                            historique = historique + "AFX, ";
                            System.out.println("Super concert de AFX");
                            break;
                        case "x&trick":
                            energie = energie - 2;
                            temps = temps - 60;
                            historique = historique + "x&trick, ";
                            System.out.println("Super concert de x&trick");
                            break;
                        case "deathmachine":
                            energie = energie - 3;
                            temps = temps - 60;
                            historique = historique + "deathmachine, ";
                            System.out.println("Super concert de deathmachine");
                            break ;
                        case "clarck":
                            energie = energie - 2;
                            temps = temps - 45;
                            historique = historique + "clarck, ";
                            System.out.println("Super concert de clarck");
                            break;
                        default:
                            System.out.println("Ca n'est pas au programme");
                    }
                break;
            case "jazz":
                System.out.println("Il y en aura peut être l'année prochaine ;)");
                energie --;
                break;
            case "classique":
                System.out.println("Il y en aura peut être l'année prochaine ;)");
                energie --;
                break;
            default:
                System.out.println("t'as mal écris");
        }
            int evenement = (int)(Math.random() * 3 + 1);
            if (evenement == 1 ) {
                System.out.println("On vous offre une bière: " );
                energie = energie + 2;
            }

            System.out.println("énergie: " + energie);
            System.out.println("temps encore dispo: " + temps + " minutes" );
        }while (energie > 0 && temps > 0 );
        System.out.println("Historique: " + historique);
        System.out.println("A l'année prochaine!");

    }
}
