package org.example.exercice01BuilderPizza;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pizza {


    private Taille taille;
    private TypePate typePate;
    private Set<Fromage> fromage = new HashSet<>();
    private Set<Garnitures> garnitures = new HashSet<>();
    private TypeSauce typeSauce;

    public enum Taille{
        PETITE, MOYENNE, GRANDE
    }

    public enum TypePate{
        CLASSIQUE, FINE, EPAISSE
    }

    public enum Fromage{
        MOZZARELLA, CHEDDAR, SANSFROMAGE
    }

    public enum Garnitures {
        JAMBON, PEPPERONI, CHAMPIGNONS, POIVRONS
    }

    public enum TypeSauce{
        TOMATE, CREME, BARBECUE
    }

    private Pizza(PizzaBuilder builer){
        this.taille = builer.taille;
        this.typePate = builer.typePate;
        this.fromage = builer.fromage;
        this.garnitures = builer.garnitures;
        this.typeSauce = builer.typeSauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille=" + taille +
                ", typePate=" + typePate +
                ", fromage=" + fromage +
                ", garnitures=" + garnitures +
                ", typeSauce=" + typeSauce +
                '}';
    }

    public static class PizzaBuilder{
        private Taille taille;
        private TypePate typePate;
        private Set<Fromage> fromage = new HashSet<>();
        private Set<Garnitures> garnitures = new HashSet<>();
        private TypeSauce typeSauce;

        public PizzaBuilder taille(Taille taille){
            this.taille = taille;
            return this;
        }
        public PizzaBuilder typePate(TypePate typePate){
            this.typePate = typePate;
            return this;
        }
        public PizzaBuilder fromage(Fromage fromage){
            this.fromage.add(fromage) ;
            return this;
        }
        public PizzaBuilder garnitures(Garnitures garnitures){
            this.garnitures.add(garnitures) ;
            return this;
        }
        public PizzaBuilder typeSauce(TypeSauce typeSauce){
            this.typeSauce = typeSauce;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }

}
