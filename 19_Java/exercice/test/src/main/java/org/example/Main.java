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

        System.out.println("Exercice 1");
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
        System.out.println("Entrez un second message");
        String messageB = scanner.nextLine();
        LocalDateTime timeB = LocalDateTime.now();

        Duration time = Duration.between(timeA, timeB);
        long response = time.getSeconds();

        System.out.println("Il s'est écoulé " +  response + " secondes entre les deux messages");
    }
}