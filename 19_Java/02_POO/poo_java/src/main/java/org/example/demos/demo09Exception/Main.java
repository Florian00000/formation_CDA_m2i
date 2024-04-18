package org.example.demos.demo09Exception;

import java.util.Scanner;

public class Main {

        // Slide 8 du support
        // Exemple division par 0 provoque une erreur

        public static int calcul(int a,int b){
            int c=a/b;
            return c;
        }

        public static void main(String[] args) {
            Scanner clavier = new Scanner(System.in);
            System.out.print("Donner a:");
            int a = clavier.nextInt();
            System.out.print("Donner b:");
            int b = clavier.nextInt();
            int resultat = calcul(a, b);
            System.out.println("Resultat=" + resultat);

        }

}
