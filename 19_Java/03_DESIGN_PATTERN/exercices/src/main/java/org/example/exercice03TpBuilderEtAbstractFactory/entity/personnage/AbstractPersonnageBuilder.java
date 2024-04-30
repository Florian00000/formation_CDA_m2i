package org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage;

public abstract class AbstractPersonnageBuilder {
    protected String nom;
    protected int force;
    protected int magic;

    public AbstractPersonnageBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public AbstractPersonnageBuilder force(int force) {
        this.force = force;
        return this;
    }

    public AbstractPersonnageBuilder magic(int magic) {
        this.magic = magic;
        return this;
    }

    public abstract Personnage build();
}
