package org.example.exercice08CompteBancaire;

public class Operation {
    private int numero;
    private double montant;
    private Statut statut;

    public Operation(Statut statut, int numero, double montant) {
        this.statut = statut;
        this.numero = numero;
        this.montant = montant;
    }
}
