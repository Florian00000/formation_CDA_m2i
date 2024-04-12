package org.example.exercice08CompteBancaire;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    public static int idClient = 0;
    private String nom;
    private String prenom;
    private List <CompteBancaire> listeCompte = new ArrayList<CompteBancaire>();

    public Client( String nom, String prenom) {
        this.id = idClient;
        idClient++;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Client{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
