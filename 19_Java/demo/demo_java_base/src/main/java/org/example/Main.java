package org.example;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Création d'une variable
        /*int age;
        age = 36;
        System.out.println(age);

        boolean test = true;
        System.out.println(test);
        float prix = 10.99F;
        System.out.println(prix);
        double solde = 100_000.97;
        System.out.println(solde);
        char  c = 'c';
        long bigNumber = 1000000000000000000L;
        System.out.println(c);
        var firstname = "ihab";
        System.out.println(firstname.toUpperCase());

        //Lire à partir de l'écran => JSE => Scanner
        Scanner scanner = new Scanner(System.in);

        String saisi = scanner.nextLine();
        System.out.println(saisi);
        int saisiInt = scanner.nextInt();
        System.out.println(saisiInt);
        float saisiFloat = scanner.nextFloat();
        System.out.println(saisiFloat);*/

        //Exercice 1

        Scanner scanner = new Scanner(System.in);

       /* System.out.println("Entrez la température en Celsius :");
        float celsius = scanner.nextFloat();
        float fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("La température en Fahrenheit est : " + fahrenheit);

        System.out.println("Entrez la température en Fahrenheit :");
        float fahrenheint  = scanner.nextFloat();
        float celsiusConvert = (fahrenheint - 32) * 5 / 9;
        System.out.println("La température en Celsius est : " + celsiusConvert);*/

        //Exercice 2

       /* System.out.println("Exercice 2");
        System.out.println("Entrez le nombre de bonbons à acheter");
        int nbBonbons = scanner.nextInt();
        System.out.println("Entrez le prix des bonbons");
        float prixBonbons = scanner.nextFloat();
        float prixTotal = nbBonbons * prixBonbons ;
        System.out.println(prixTotal + " euros");*/


        //Exercice 3
        /*System.out.println("Merci de saisir le message 1 : ");
        String premierMessage = scanner.nextLine();
        long debutTemps = System.currentTimeMillis();
        System.out.println("Merci de saisir le message 2 : ");
        String deuxiemeMessage = scanner.nextLine();
        long finTemps = System.currentTimeMillis();
        long tempsEcoule = finTemps - debutTemps;
        double tempsEcouleEnSecondes = tempsEcoule / 1000.0;

        System.out.println("Le temps entre message 1 "+premierMessage + " et le message 2 " + deuxiemeMessage + " est : "+tempsEcouleEnSecondes + " secondes");*/

        //Structure conditionnelle
        // => If else (dans if elseif else) => si(conditions) sinon
        //int age = scanner.nextInt();

        /*if(age >= 18) {
            System.out.println("Majeur");
        }else{
            System.out.println("Mineur");
        }*/

        /*if(age >8 && age <= 11) {
            System.out.println("Poussin");
        } else if(age > 11 && age <= 13) {
            System.out.println("Benjamin");
        } else if (age > 13 &&  age <=15) {
            System.out.println("Minime");
        } else if(age > 15 && age <= 17) {
            System.out.println("Cadet");
        } else if(age > 17 && age <= 20) {
            System.out.println("Junior");
        } else if(age > 20) {
            System.out.println("Senior");
        } else {
            System.out.println("Pas de catégorie");
        }*/

        //Switch

        /*int numeroMois = scanner.nextInt();

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
            //....

            default:
                System.out.println("Default Value");
                break;
        }*/

        //Ternaire

        /*String statut = (age >= 18) ? "majeur" : "mineur";
        System.out.println(statut);*/


        //Exercice 1 => structure conditionnelle

        /*System.out.println("Vous vous trouvez devant le dortoir abandonné vous pouvez choisir d'y entrer en entrant 1 , " +
                "d'appeller un professeur en entrant 2  ou d'ignorer l'appel à l'aide de votre ami en entrant 3, \nVotre choix : ");




        String saisi = scanner.nextLine();


        switch (saisi) {
            case "1":
                System.out.println("Après avoir remporté le duel face à Titan et sauver votre ami vous obtener des informations sur Atticus");
                break;
            case "2":
                System.out.println("Vous avez appelé un professeur qui vous à aidé a vous en sortir mais vos amis on été bléssé");
                break;
            case "3":
                System.out.println("Personne ne sais ce qu'il ai arrivé à vos amis mais vous senter votre âme pesé plus lourde");
                break;
            //....

            default:
                System.out.println("Veuillez entrer une valeur incluse");
                break;
        }*/

        //Exercice 2 => structure conditionnelle

        /*System.out.println("Pensez à un animal et je vais le devinez ");
        System.out.println("L'animal vit-il dans l'eau");
        System.out.println("1. Oui");
        System.out.println("2. Non");
        int choixUtilisateur = scanner.nextInt();
        if(choixUtilisateur == 1) {
            //Instruction choix 1
            System.out.println("L'animal est un poisson");
        }else {
            //Instruction choix 2
            System.out.println("l'animal est un terrestre");
            //Poser plus de question
        }*/

        //Exercice 3 => structure conditionnelle

        /*System.out.println("Merci d'indiquer un choix : \n 1. Force \n 2. Intelligence \n 3. Vitesse");

        String choixUtilisateur = scanner.nextLine().toLowerCase();

        String superHero;
        switch (choixUtilisateur) {
            case "force":
                superHero = "Hulk";
                break;
            case "intelligence":
                superHero = "Superman";
                break;
            case "vitesse":
                superHero = "Flash";
                break;
            default:
                superHero = null;
        }
        if(superHero.equals(null)) {
            System.out.println("Erreur de choix");
        }else {
            System.out.println("Votre personnalité est similaire à "+ superHero);
        }*/

        //Exercice 4 => structure conditionnelle

        /*System.out.println("Décrivez votre humeur du jour. Par exemple: joyeux, triste, aventurier");

        String choiceMood = scanner.nextLine().toLowerCase();

        switch(choiceMood){
            case "joyeux":
                System.out.println("Sortez prendre un verre avec des amis");
                break;
            case "triste":
                System.out.println("Faites une activité qui vous plait et relaxez vous");
                break;
            case "aventurier":
                System.out.println("Partez faire une petite randonnée en pleine nature");
                break;

            default:
                System.out.println("Ne faites rien");
                break;
        }*/

        // Structures itératives
        // for => pour un interval de valeurs
        /*for(int i = 10; i < 30; i++) {
            System.out.println(i);
        }
        for(int i = 10; i > 5; i=i-2) {
            System.out.println(i);
        }

        for(int i = 1; i < 30; i++) {
            if(i%6 == 0) {
                break;
            }
        }

        for(int i=1; i <10; i++) {
            if(i%2 == 0) {
                continue;
            }
            System.out.println(i);
        }*/

        /*int i = 1;
        while(i < 10) {
            System.out.println(i);
            i++;
        }*/
        /*int choix = 0;
        while (true) {
            System.out.println("Votre choix : ");
            choix = scanner.nextInt();
            if(choix > 100) {
                break;
            }
        }*/
        /*int choix;
        do {
            System.out.println("Votre choix : ");
            choix = scanner.nextInt();
        }while (choix <= 100);*/

        //Exercice 1 => structure itérative
        /*int nombreMystere = (int) ((Math.random() * 100) + 1);
        int valeurMinimum = 0;
        int valeurMaximum = 100;
        int nombreChoisi;
        int nombreEssai = 10;
        do {
            System.out.println("Entrez un nombre entre " + valeurMinimum + " et " + valeurMaximum);
            nombreChoisi = scanner.nextInt();
            if (nombreChoisi > valeurMinimum && nombreChoisi < valeurMaximum) {
                if (nombreChoisi < nombreMystere) {
                    System.out.println("Le nombre mystère est plus grand !");
                    valeurMinimum = nombreChoisi;
                } else if (nombreChoisi > nombreMystere) {
                    System.out.println("Le nombre mystère est plus petit !");
                    valeurMaximum = nombreChoisi;
                } else {
                    System.out.println("Bravo vous avez gagné");
                }
            } else {
                System.out.println("Votre proposition est en dehors des limites !");
            }
            nombreEssai--;
        } while (nombreChoisi != nombreMystere && nombreEssai > 0);
        if(nombreEssai == 0) {
            System.out.println("vous avez perdu");
        }*/

        //Exercice 2

        /*System.out.println("Entrez un nombre de départ");
        int debut = scanner.nextInt();
        System.out.println("Entrez un nombre d'arrivée");
        int stop = scanner.nextInt();
        System.out.println("Comptons de " + debut +" à " + stop);
        int pas = (debut < stop) ? 1 : -1;


        do  {
            System.out.println(debut);
            debut += pas;
        }while(debut != stop);*/

        //Exercice 3

        // exercice 3
        int userPoints = 0;
        int nbrQuestions = 1;
        String promptUser;
        do {
            System.out.println(userPoints);
            switch (userPoints){
                case 0:
                    System.out.println("Quelle est la capitale du Sri-Lanka");
                    promptUser = scanner.nextLine().toLowerCase();
                    if (promptUser.equals("colombo")) {
                        userPoints++;
                        continue;
                    }
                    break;
                case 1:
                    System.out.println("Qui est l'homme le plus classe du monde");
                    promptUser = scanner.nextLine().toLowerCase();
                    if (promptUser.equals("georges abidbol")) {
                        userPoints++;
                        continue;
                    }
                    break;
            }
            userPoints = 0;
        }while (userPoints <= nbrQuestions);
        System.out.println("Bravo!");

        //Exercice 4
        System.out.print("Saisir un motif : ");
        char motif = scanner.next().charAt(0);

        System.out.print("Saisir le nombre de lignes : ");
        int nombreLignes = scanner.nextInt();

        int nombreEspace = nombreLignes - 1;

        for (int ligne = 1; ligne <= nombreLignes; ligne++) {
            for (int i = 0; i < nombreEspace; i++) {
                System.out.print(" ");
            }
            for (int colonne = 1; colonne <= ligne; colonne++) {
                System.out.print(motif + " ");
            }
            nombreEspace--;
            System.out.println();
        }

    }
}