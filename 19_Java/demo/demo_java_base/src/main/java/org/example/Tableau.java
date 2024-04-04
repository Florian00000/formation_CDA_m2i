package org.example;

public class Tableau {
    public static void main(String[] args) {
        //Création d'un tableau
        int[] tabEntier = new int[10];
        //Les éléments du tableau ont un index entre 0 et taille-1
        tabEntier[0] = 1;
        //System.out.println(tabEntier[0]);
        tabEntier[0] = 3;
        //System.out.println(tabEntier[0]);

        //Parcourir un tableau
        /*for(int i=0; i < tabEntier.length; i++) {
            System.out.println(tabEntier[i]);
        }*/
        /*int taille = 10;
        String[] tabChaine = new String[taille];
        boolean[] tabBoolean = new boolean[taille];
        for(int i=0; i < taille; i++) {
            //tabBoolean[i] = i%2 == 0;
            System.out.println(" valeur tab Chaine : "+ i +" : "+tabChaine[i]);
            System.out.println(" valeur tab Boolean : "+ i +" : "+tabBoolean[i]);
        }

        for(int i=0; i < taille; i++) {
            tabBoolean[i] = false;
            System.out.println(tabBoolean[i]);
        }*/

        /*String[] tabChaine = {"a", "b", "c", "toto"};
        for(int i=0; i < tabChaine.length; i++) {
            System.out.println(tabChaine[i]);
        }
        //Parcourir avec un foreach
        for(String element : tabChaine) {
            System.out.println(element);
        }*/
        String[][] tab2D = new String[2][];

        tab2D[0] = new String[3];
        tab2D[1] = new String[2];
        //String[][] tab2D = {{"A","B", "C"}, {"D", "E"}};
        for(int i=0; i < tab2D.length; i++) {
            for(int j=0; j < tab2D[i].length; j++) {
                System.out.println("Element à la case i "+i + ", j "+j + " = "+ tab2D[i][j] );
            }
        }

        for(String[] tab : tab2D) {
            for(String element : tab) {
                System.out.println(element);
            }
        }


    }
}
