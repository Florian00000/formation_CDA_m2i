package org.example.exercices.exercice06Pendu;

import java.util.Random;

public class GenerateurDeMots {

    private static String[] listeDeMots =
        {
                "poubelle",
                "friture",
                "shampoing",
                "chaussettes",
                "parapluie",
                "canard",
                "moufette",
                "prétendant",
                "caméléon",
                "brique",
                "ciseaux",
                "crabe",
                "brosse",
                "dentifrice",
                "niche",
                "soupe",
                "crêpière",
                "ordinateur",
                "souffleuse",
                "filière",
                "allumettes",
                "grattoir",
                "xylophone",
                "guitare",
                "feuille",
                "guignol",
                "jetable",
                "figaro",
                "institution",
                "karaoke",
                "toilette",
                "chansons",
                "kimono",
                "trouillard",
                "chipolata",
                "questionnement",
                "partir",
                "chipoter",
                "jeton",
                "fournitures",
                "wasabi"
        };

    public static String GenererMot(){
        return listeDeMots[new Random().nextInt(listeDeMots.length)];

        // équivalent :
//        Random rand = new Random();
//        int nbAleatoire = rand.nextInt(listeDeMots.length);
//        return listeDeMots[nbAleatoire];
    }
}
