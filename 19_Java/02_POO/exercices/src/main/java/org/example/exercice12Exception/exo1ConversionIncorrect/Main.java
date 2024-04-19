package org.example.exercice12Exception.exo1ConversionIncorrect;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean reponseCorrecte = false;
        do {
            try {
                System.out.println("Entrer un entier");
                String saisie = scanner.nextLine();
                Integer entier = Integer.parseInt(saisie);
                System.out.println(entier);
                reponseCorrecte = true;
                System.out.println("bien joué!");
            }catch (NumberFormatException e) {
                System.out.println("Erreur entrer un entier");
            }
        }while (!reponseCorrecte);
    }
}
