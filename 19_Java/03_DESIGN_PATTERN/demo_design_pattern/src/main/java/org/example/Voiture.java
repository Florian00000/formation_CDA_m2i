package org.example;

public class Voiture {

    private String marque;

    private String model;

    private int annee;

    private Voiture(VoitureBuilder builder) {
        //Affectation des attributs
        this.marque = builder.marque;
        this.model = builder.model;
        this.annee = builder.annee;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", model='" + model + '\'' +
                ", annee=" + annee +
                '}';
    }

    public static class VoitureBuilder {
        private String model;
        private String marque;

        private int annee;

        public VoitureBuilder marque(String marque) {
            this.marque = marque;
            return this;
        }

        public VoitureBuilder annee(int annee) {
            this.annee = annee;
            return this;
        }

        public VoitureBuilder model(String model) {
            this.model = model;
            return this;
        }

        public Voiture build() {
            return new Voiture(this);
        }
    }
}
