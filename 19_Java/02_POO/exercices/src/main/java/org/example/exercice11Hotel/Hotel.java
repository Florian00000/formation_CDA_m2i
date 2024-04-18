package org.example.exercice11Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nom;
    private List<Client> listClient = new ArrayList<>();

    private Chambre[] listeChambre;
    private List<Reservation> listeReservation = new ArrayList<>();
    private List<Client> listeClient = new ArrayList<>();

    public Hotel(String nom, int nbChambre) {
        this.nom = nom;
        this.listeChambre = new Chambre[nbChambre];

    }
}
