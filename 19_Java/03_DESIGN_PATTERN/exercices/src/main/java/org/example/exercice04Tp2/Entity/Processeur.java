package org.example.exercice04Tp2.Entity;

public class Processeur extends Produit{
    private String frequence;

    private Processeur(ProcesseurBuilder processeurBuilder) {
        super(processeurBuilder);
        this.frequence = processeurBuilder.frequence;
    }

    public static class ProcesseurBuilder extends AbstractProduitBuilder {
        private String frequence;

        public ProcesseurBuilder frequence(String frequence) {
            this.frequence = frequence;
            return this;
        }

        @Override
        public Produit build() {
            return new Processeur(this);
        }
    }
}
