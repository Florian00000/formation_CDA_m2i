package org.example.exercices.exercice06Pendu;

import java.util.Objects;

public class Pendu {
    private final String motATrouver;
    private String masque;
    private final int nbEssaisTotal;
    private int nbEssaisRestants; // 9 8 7 6 5 4 3 2 1
    private String lettresTestees = "";

    public String getMasque() {
        return masque;
    }

    public int getNbEssaisTotal() {
        return nbEssaisTotal;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public Pendu(){
        this(10);
    }

    public Pendu(int nbEssais){
        nbEssaisTotal = nbEssais;
        nbEssaisRestants = nbEssaisTotal;
        motATrouver = GenerateurDeMots.GenererMot();
        genererMasque();
    }

    public String testChar(char lettre){
        String lettreS = Character.toString(lettre);

        if(lettresTestees.contains(lettreS)){
            return "Lettre déjà testée !!!";
        }
        lettresTestees += lettreS;

        if(motATrouver.contains(lettreS)){
            genererMasque(); // possible de regénérer le masque ici
            return "La lettre est dans le mot !";
        }

        nbEssaisRestants--;
        return "La lettre n'est pas dans le mot...";
    }

    public boolean testWin(){
//        return !masque.contains("*");
        return masque.equals(motATrouver);
    }

    private void genererMasque(){ // possible de mettre public si on l'appelle en dehors de la classe
        masque = "";
        for(char lettre : motATrouver.toCharArray()){
            if (lettresTestees.contains(Character.toString(lettre)))
                masque += lettre;
            else
                masque += '*';
        }
    }
}
