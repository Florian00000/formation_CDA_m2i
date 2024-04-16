package org.example.exercices.exercice08Banque.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String nom;
    private String prenom;

    private int id;

    private List<CompteBancaire> compteBancaireList;

    private String tel;

    private static int nbClient = 0;

    public Client(String nom, String prenom, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = ++nbClient;
        this.tel = tel;
        this.compteBancaireList = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    public void setCompteBancaireList(List<CompteBancaire> compteBancaireList) {
        this.compteBancaireList = compteBancaireList;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id=" + id +
                ", tel='" + tel + '\'' +
                '}';
    }
}
