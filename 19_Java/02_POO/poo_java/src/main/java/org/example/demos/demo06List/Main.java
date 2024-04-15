package org.example.demos.demo06List;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Syntaxe pour la collection List
        List<String> prenoms = new ArrayList<String>();

        // la méthode add() pour ajouter des elements
        prenoms.add("toto");
        prenoms.add("tata");
        prenoms.add("tutu");

        // la methode get pour acceder à un element par son indice
        System.out.println(prenoms.get(0));
        System.out.println(prenoms.get(1));
        System.out.println(prenoms.get(2));

        // la methode set permet de modifier un element à un index précis
        prenoms.set(0,"guillaume");

        // La methode size() permet de retourner la taille
        System.out.println(prenoms.size());

        // la methode remove permet de supprimer un élement
        prenoms.remove(0);

        // La methode size() permet de retourner la taille
        System.out.println(prenoms.size());

        //parcourir avec la boucle foreach
        for (String prenom:prenoms){
            System.out.println(prenom);
        }

        // for
        for (int cpt = 0; cpt < prenoms.size(); cpt++){
            System.out.println(prenoms.get(cpt));
        }

        System.out.println(prenoms.get(2));



    }
}
