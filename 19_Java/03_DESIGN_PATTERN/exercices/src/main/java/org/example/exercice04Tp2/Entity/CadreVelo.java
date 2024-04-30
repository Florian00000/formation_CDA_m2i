package org.example.exercice04Tp2.Entity;

public class CadreVelo extends Produit {
    private String couleur;

    private CadreVelo(CadreVeloBuilder cadreVeloBuilderbuilder) {
        super(cadreVeloBuilderbuilder);
        this.couleur = cadreVeloBuilderbuilder.couleur;
    }

    public static class CadreVeloBuilder extends AbstractProduitBuilder{

        private String couleur;

        public CadreVeloBuilder couleur(String couleur) {
            this.couleur = couleur;
            return this;
        }

        @Override
        public Produit build() {
            return new CadreVelo(this);
        }
    }
}
