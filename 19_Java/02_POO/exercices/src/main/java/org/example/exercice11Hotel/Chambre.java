package org.example.exercice11Hotel;

public class Chambre {
    private int numero;
    private static int idChambre;
    private boolean statutLibre = true;
    private double tarif;
    private int capacite;

    public Chambre(double tarif, int capacite) {
        numero = ++idChambre;
        this.tarif = tarif;
        this.capacite = capacite;
    }
}
