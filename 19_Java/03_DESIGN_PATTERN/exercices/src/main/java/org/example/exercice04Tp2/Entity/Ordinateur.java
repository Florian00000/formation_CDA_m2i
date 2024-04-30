package org.example.exercice04Tp2.Entity;

public class Ordinateur {
    private CarteMere carteMere;
    private DisqueDur disqueDur;
    private Processeur processeur;

    private Ordinateur(OrdinateurBuilder ordinateurBuilder){
        this.carteMere = ordinateurBuilder.carteMere;
        this.disqueDur = ordinateurBuilder.disqueDur;
        this.processeur = ordinateurBuilder.processeur;
    }

    public static class OrdinateurBuilder {
        private CarteMere carteMere;
        private DisqueDur disqueDur;
        private Processeur processeur;

        public OrdinateurBuilder carteMere(CarteMere carteMere) {
            this.carteMere = carteMere;
            return this;
        }

        public OrdinateurBuilder processeur(Processeur processeur) {
            this.processeur = processeur;
            return this;
        }

        public OrdinateurBuilder disqueDur(DisqueDur disqueDur) {
            this.disqueDur = disqueDur;
            return this;
        }

        public Ordinateur build() {
            return new Ordinateur(this);
        }
    }


}
