package org.example.exercice12Exception.exo2RacineCarre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean over = true;
        while (over) {
            try {
                System.out.println("Entrer un nombre positif: ");
                int nombre = scanner.nextInt();
                if (nombre < 0) {
                    throw new IllegalArgumentException("Erreur: Le nombre doit être positif");
                }
                double racineCaree = Math.sqrt(nombre);
                System.out.println("La racine carrée de " + nombre + " est: " + racineCaree );
                over = false;
            } catch (InputMismatchException e) {
                System.out.println("Erreur: entrée non numérique. Veuillez entrer un nombre positif!!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }finally {
                scanner.nextLine(); //Permet de "consommer la touche entrée" appuyé par l'utilisateur au moment de la
                                    //saisie de l'entier.
            }

        }
    }
}
