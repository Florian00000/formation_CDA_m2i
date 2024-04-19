package org.example.exercice12Exception.exo3;

public class Main {
    public static void main(String[] args) {
        int[] tableau = {1, 2, 3, 4, 5};

        try {
            int element = getElement(tableau, 4);
            System.out.println("Element récupéré: " + element);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Erreur : Index hors limites!!");
        }

    }

    public static int getElement(int[] tableau, int index){
        return tableau[index];
    }
}
