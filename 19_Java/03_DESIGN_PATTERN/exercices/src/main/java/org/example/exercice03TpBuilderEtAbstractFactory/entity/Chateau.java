package org.example.exercice03TpBuilderEtAbstractFactory.entity;

public class Chateau extends Batiment{

    private int taille;
    private String nom;
    private String style;

    private Chateau(ChateauBuilder builder){
        taille = builder.taille;
        nom = builder.nom;
        style = builder.style;
    }
    public static class ChateauBuilder extends AbstractBatimentBuilder{

        private int taille;
        private String nom;
        private String style;

        public ChateauBuilder taille(int taille){
            this.taille = taille;
            return this;
        }

        public ChateauBuilder nom(String nom){
            this.nom = nom;
            return this;
        }

        public ChateauBuilder style(String style){
            this.style = style;
            return this;
        }

        @Override
        public Batiment build() {
            return new Chateau(this);
        }
    }
}
