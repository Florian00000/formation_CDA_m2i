package org.example.exercice04Tp2.Factory;

import org.example.exercice04Tp2.Entity.CarteMere;
import org.example.exercice04Tp2.Entity.DisqueDur;
import org.example.exercice04Tp2.Entity.Ordinateur;
import org.example.exercice04Tp2.Entity.Processeur;

public class OrdinateurFactory extends ProduitFactory {

    private CarteMere carteMere;
    private DisqueDur disqueDur;
    private Processeur processeur;

    public void avecCarteMere(CarteMere carteMere) {
        this.carteMere = carteMere;
    }

    public void avecDisqueDur(DisqueDur disqueDur) {
        this.disqueDur = disqueDur;
    }

    public void avecProcesseur(Processeur processeur) {
        this.processeur = processeur;
    }

    public Ordinateur createOrdinateur(Ordinateur.OrdinateurBuilder ordinateurBuilder) {
        return ordinateurBuilder.carteMere(carteMere).disqueDur(disqueDur).processeur(processeur).build();
    }
}
