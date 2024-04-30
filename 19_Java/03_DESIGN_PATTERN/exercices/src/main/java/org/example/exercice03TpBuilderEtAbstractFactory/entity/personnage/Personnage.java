package org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage;

public abstract class Personnage {

    protected String nom;
    protected int force;
    protected int magic;

    protected Personnage(AbstractPersonnageBuilder builder){
        this.nom = builder.nom;
        this.force = builder.force;
        this.magic = builder.magic;
    }
}
