package org.example.exercice12Exception.exo4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        try {
            while (true){
                System.out.println("Ajout d'un nouvel étudiant: ");
                System.out.println("Nom: ");
                String name = scanner.next();
                System.out.println("Age: ");
                int age = scanner.nextInt();

                students.add(new Student(name, age));
                System.out.println();
            }
        }catch (InputMismatchException e){
            System.out.println("Erreur: Format d'ajout invalide. Fin de la saisie");
        }catch (InvalidAgeException e ){
            System.out.println("erreur : " + e.getMessage()  + " Veuillez saisir à nouveau l'age.");
            scanner.nextLine();
        }finally {
            //Affichage des étudiants
            System.out.println("\n Lise des étudiants ");
            students.stream().forEach(System.out::println);
            scanner.close();
        }
    }
}
