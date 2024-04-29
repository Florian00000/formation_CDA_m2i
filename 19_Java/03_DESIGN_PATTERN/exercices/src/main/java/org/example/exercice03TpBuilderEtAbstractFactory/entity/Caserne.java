package org.example.exercice03TpBuilderEtAbstractFactory.entity;

public class Caserne extends Batiment{

    private String nom;

    private Caserne(CaserneBuilder builder){
        nom = builder.nom;
    }

    public static class CaserneBuilder extends AbstractBatimentBuilder{

        private String nom;

        public CaserneBuilder nom(String nom){
            this.nom = nom;
            return this;
        }

        @Override
        public Caserne build() {
            return new Caserne(this);
        }
    }
}
