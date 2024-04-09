package org.example;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// ou
//import java.util.regex.*;

public class exercicesFonctionsJava {

    static Scanner scanner = new Scanner(System.in);

    public static String nomComplet(String prenom, String nom) {
        return prenom + " " + nom;
    }

    public static int soustraire(int a, int b) {
        System.out.println("Je soustrai " + a + " et " + b);
        return a - b;
    }

    public static void quelleHeure() {
        System.out.println("il est 12h00");
    }

    public static void quelleHeure(String heure) {
        System.out.println("il est " + heure);
    }

    public static int compterLetteA(String chaine) {
        chaine = chaine.toLowerCase();
        char[] tab = chaine.toCharArray();
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 'a') {
                somme++;
            }
        }
        return somme;
    }

    public static boolean verificationAdn(String chaine) {
        chaine = chaine.toUpperCase();
        char[] tab = chaine.toCharArray();
        boolean reponse = true;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != 'A' && tab[i] != 'T' && tab[i] != 'C' && tab[i] != 'G') {
                reponse = false;
                return reponse;
            }
        }
        return reponse;
    }

    public static String saisieAdn() {
        boolean validation = false;
        String saisie;
        do {
            System.out.println("Entrez une chaine de caractère valable");
            saisie = scanner.nextLine();
            validation = verificationAdn(saisie);
        } while (!validation);
        return saisie.toUpperCase();
    }

    public static double proportion(String chaine, String sequence) {
        int nbOccurences = 0;

        //1e essai
//        for (int i = 0; i < chaine.length(); i++) {
//            int test =sequence.length();
//            String sequenceCompare = chaine.substring( i,(sequence.length()));
//            if (sequenceCompare.equals(sequence) ){
//                nbOccurences++;
//            };
//        }

        Pattern pattern = Pattern.compile(sequence);
        Matcher matcher = pattern.matcher(chaine);

        while (matcher.find()) {
            nbOccurences++;
        }


        return (double) (nbOccurences * sequence.length() * 100) / chaine.length();

    }

    public static void main(String[] args) {
        System.out.println(nomComplet("Florian", "Delafosse"));
        System.out.println(soustraire(2, 1));
        quelleHeure();
        quelleHeure("14h00");
        System.out.println(compterLetteA("baba"));
        System.out.println("ADN");

        //Adn
        System.out.println(verificationAdn("test"));
        System.out.println(verificationAdn("tacg"));

        String chaine = saisieAdn();
        String sequence = saisieAdn();

        System.out.println(proportion(chaine, sequence));
    }
}
