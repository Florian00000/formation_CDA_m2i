package org.example.demos.demo05Generique.model;

public class Boite<T> {

    private T contenu;

    //Constructeur
    public Boite(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }
}
