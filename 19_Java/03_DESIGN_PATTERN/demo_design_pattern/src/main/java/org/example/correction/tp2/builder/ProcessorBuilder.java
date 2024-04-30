package org.example.correction.tp2.builder;

import org.example.correction.tp2.entity.Processor;

public class ProcessorBuilder {

    private String type;
    private int nbCoeur;

    public String getType() {
        return type;
    }

    public int getNbCoeur() {
        return nbCoeur;
    }

    public ProcessorBuilder type(String type) {
        this.type = type;
        return this;
    }
    public ProcessorBuilder nbCoeur(int nbCoeur) {
        this.nbCoeur = nbCoeur;
        return this;
    }

    public Processor build() {
        return new Processor(this);
    }
}
