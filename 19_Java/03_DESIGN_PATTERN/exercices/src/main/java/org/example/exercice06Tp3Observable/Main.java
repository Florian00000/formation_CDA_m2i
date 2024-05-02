package org.example.exercice06Tp3Observable;

public class Main {
    public static void main(String[] args) {
        Investisseur inv1 = new Investisseur();

        Marche marche = new Marche();

        //TODO suivre des actions et tester lancement marché

        marche.getListeActions().stream().forEach(a -> System.out.println(a));
        //inv1.suivreAction(marche.);
        marche.lancementMarche();
    }
}
