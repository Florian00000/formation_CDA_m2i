package org.example.demos.demo3Heritage;

public abstract class Felin extends Animal{
    protected String nom; // accessible librement DANS LES CLASSES FILLES

    public Felin(String nom, int age) {
        super(age);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void crier() {
        System.out.println("Le félin rugi !");
    }
}
