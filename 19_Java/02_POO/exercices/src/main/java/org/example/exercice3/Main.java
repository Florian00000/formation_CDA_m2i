package org.example.exercice3;

public class Main {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("Georges");

        while (joueur1.getNiveau() < 10){
            joueur1.effectuerUneQuete();
        }
    }

}
