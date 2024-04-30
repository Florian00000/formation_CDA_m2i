package org.example.exercice04Tp2.Entity;

public class CarteMere extends Produit{
    private String Connectique;

    private CarteMere(CarteMereBuilder carteMereBuilder) {
        super(carteMereBuilder);
        this.Connectique = carteMereBuilder.Connectique;
    }

    public static class CarteMereBuilder extends AbstractProduitBuilder{

        private String Connectique;

        public CarteMereBuilder Connectique(String Connectique) {
            this.Connectique = Connectique;
            return this;
        }

        @Override
        public Produit build() {
            return new CarteMere(this);
        }
    }
}
