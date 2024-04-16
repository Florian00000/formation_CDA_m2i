package org.example.exercices.exercice08Banque;

import java.util.Scanner;

public class IHMConsole {

    private static Scanner scanner = new Scanner(System.in);

    public static void start(){
        int choix;
        do{
            afficheMenuBase();
            choix = scanner.nextInt();

            /*
            switch (choix){
                case 1:
                    choixOne();
                    break;
                case 2:
                    choixTwo();
                    break;
                case 3:
                    choixThree();
                    break;
                case 4:
                    choixFour();
                    break;
                case 0:
                    System.out.println("Au revoir !!!");
                    break;
                default:
                    System.out.println("Choix invalide !!!!");

            }

             */
            switch (choix){
                case 1 -> choixOne();
                case 2 -> choixTwo();
                case 3 -> choixThree();
                case 4 -> choixFour();
                case 0 -> System.out.println("Au revoir !!!");
                default -> System.out.println("Choix invalide !!!!");
            }

        } while (choix != 0);


    }

    public static void afficheMenuBase(){
        System.out.println("##### Menu Base #######");
        System.out.println("1) Choix un");
        System.out.println("2) Choix deux");
        System.out.println("3) Choix trois");
        System.out.println("4) Choix quatre");
        System.out.println("0) Quitter");
        System.out.println("Faite votre choix : ");
    }

    public static void choixOne(){
        System.out.println("Vous avex fait le choix 1");
    }

    public static void choixTwo(){
        System.out.println("Vous avex fait le choix 2");
    }

    public static void choixThree(){
        System.out.println("Vous avex fait le choix 3");
    }

    public static void choixFour(){
        System.out.println("Vous avex fait le choix 4");
    }

}
