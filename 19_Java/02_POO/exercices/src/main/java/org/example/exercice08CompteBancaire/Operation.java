package org.example.exercice08CompteBancaire;

public class Operation {
    private int numero;
    private double montant;
    private Statut statut;
    private static int idNumero = 0;

    public Operation(Statut statut, double montant) {
        this.statut = statut;
        this.numero = idNumero++;
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }
}
