package org.example.demos.demo09Exception.compte;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Compte cp=new Compte();
        Scanner clavier=new Scanner(System.in);
        System.out.print("Montant à verser:");
        float mt1;
        mt1=clavier.nextFloat();
        cp.verser(mt1);
        System.out.println("Solde Actuel:"+cp.getSolde());
        System.out.print("Montant à retirer:");
        float mt2=clavier.nextFloat();
        // cp.retirer(mt2); // Le comilateur signe l’Exception


        // solution 1
        try {
            cp.retirer(mt2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
