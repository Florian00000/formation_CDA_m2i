package org.example.exercice04Tp2.Entity;

public class DisqueDur extends Produit{
    private int taille;

    private DisqueDur(DisqueDurBuilder disqueDurBuilder) {
        super(disqueDurBuilder);
        this.taille = disqueDurBuilder.taille;
    }

    public static class DisqueDurBuilder extends AbstractProduitBuilder {

        private int taille;

        public DisqueDurBuilder taille(int taille) {
            this.taille = taille;
            return this;
        }

        @Override
        public Produit build() {
            return new DisqueDur(this);
        }
    }
}
