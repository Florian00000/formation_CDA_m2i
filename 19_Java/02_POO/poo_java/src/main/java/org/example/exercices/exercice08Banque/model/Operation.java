package org.example.exercices.exercice08Banque.model;

import org.example.exercices.exercice08Banque.enums.Statut;

public class Operation {

    private int numero;

    private double mnt;

    private Statut statut;

    private static int nbOpe = 0;

    public Operation(double mnt, Statut statut) {
        this.numero = ++nbOpe;
        this.mnt = mnt;
        this.statut = statut;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMnt() {
        return mnt;
    }

    public void setMnt(double mnt) {
        this.mnt = mnt;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "\t Operation : " +
                "numero = " + numero +
                ", montant = " + mnt +
                ", statut = " + statut +
                '.';
    }
}
