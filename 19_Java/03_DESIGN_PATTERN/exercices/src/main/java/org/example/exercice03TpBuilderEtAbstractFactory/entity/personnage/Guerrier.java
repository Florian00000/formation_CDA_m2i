package org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage;

public class Guerrier extends Personnage {

    private int armure;



    private Guerrier (GuerrierBuilder guerrierBuilder) {
        super(guerrierBuilder);
        this.armure = guerrierBuilder.armure;
    }

    public static class GuerrierBuilder extends AbstractPersonnageBuilder {

        private int armure;

        public GuerrierBuilder armure (int armure){
            this.armure = armure;
            return this;
        }

        @Override
        public Personnage build() {
            return new Guerrier(this);
        }
    }
}
