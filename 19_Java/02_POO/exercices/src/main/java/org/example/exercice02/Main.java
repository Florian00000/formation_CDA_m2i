package org.example.exercice02;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Film film1 = new Film("La Haine 2", "Mathieu Kassovitz", LocalDate.of(2024, 4, 9), "Drame" );

        System.out.println(film1);
    }


}
