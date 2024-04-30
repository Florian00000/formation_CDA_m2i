package org.example.exercice04Tp2.Entity;

public class Roue extends Produit {
    private int taille;
    private String type;

    private Roue(RoueBuilder roueBuilder) {
        super(roueBuilder);
        this.taille = roueBuilder.taille;
        this.type = roueBuilder.type;
    }

    public static class RoueBuilder extends AbstractProduitBuilder {

        private int taille;
        private String type;

        public RoueBuilder taille(int taille) {
            this.taille = taille;
            return this;
        }

        public RoueBuilder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public Produit build() {
            return new Roue(this);
        }
    }
}
