package org.example.exercices.exercice02Film;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Film laHaine = new Film("La Haine", "Mathieu Kassovitz", LocalDate.of(1995, 5, 31), "Drame");
        Film avatar2 = new Film("Avatar 2", "James Cameron", LocalDate.of(2022, 12, 14), "Action");

        System.out.println(laHaine);
        laHaine.afficher();
        avatar2.afficher();
    }
}
