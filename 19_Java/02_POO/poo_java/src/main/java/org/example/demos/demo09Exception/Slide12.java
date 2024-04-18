package org.example.demos.demo09Exception;

import java.util.Scanner;

public class Slide12 {
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
        int resultat = 0;
        try {
            resultat = calcul(a, b);
        } catch (ArithmeticException e) {

            System.out.println("Division par zero");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            //e.printStackTrace();
            System.out.println("fin print");
        }
        System.out.println("Resultat=" + resultat);
    }

}
