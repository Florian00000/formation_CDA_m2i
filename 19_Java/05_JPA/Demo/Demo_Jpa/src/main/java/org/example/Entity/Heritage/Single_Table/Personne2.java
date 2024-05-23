package org.example.Entity.Heritage.Single_Table;


import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@SuperBuilder
public abstract class Personne2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String nom;
    protected String prenom;


    public Personne2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
