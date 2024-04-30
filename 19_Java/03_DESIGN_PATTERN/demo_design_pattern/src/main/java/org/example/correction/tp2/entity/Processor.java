package org.example.correction.tp2.entity;

import org.example.correction.tp2.builder.ProcessorBuilder;

public class Processor {
    private String type;
    private int nbCoeur;

    public Processor(ProcessorBuilder builder) {
        type = builder.getType();
        nbCoeur = builder.getNbCoeur();
    }
}
