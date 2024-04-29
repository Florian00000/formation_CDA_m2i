package org.example.correction;

import java.util.*;

public class Pizza {
    private String taille;
    private String typePate;
    private String fromage;
    private Set<String> garnitures;

    private String typeSauce;

    private Pizza(Builder builder) {
        this.fromage = builder.fromage;
        this.typePate = builder.typePate;
        this.taille = builder.taille;
        this.typeSauce = builder.typeSauce;
        this.garnitures = builder.garnitures;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille='" + taille + '\'' +
                ", typePate='" + typePate + '\'' +
                ", fromage='" + fromage + '\'' +
                ", garnitures=" + garnitures +
                ", typeSauce='" + typeSauce + '\'' +
                '}';
    }

    public static class Builder  {
        private String taille;
        private String typePate;
        private String fromage;
        private Set<String> garnitures = new HashSet<>();
        private String typeSauce;
        public Builder taille(String taille) {
            this.taille = taille;
            return this;
        }
        public Builder typePate(String typePate) {
            this.typePate = typePate;
            return this;
        }
        public Builder fromage(String fromage) {
            if(this.fromage != null)
                throw new RuntimeException("Un fromage a déjà été choisi");
            this.fromage = fromage;
            return this;
        }
        public Builder typeSauce(String typeSauce) {
            this.typeSauce = typeSauce;
            return this;
        }
        public Builder garnitures(String... garniture) {
            this.garnitures.addAll(Arrays.stream(garniture).toList());
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
