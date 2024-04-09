package org.example.exercice3;

public class Joueur {

    private String nom;
    private int niveau = 1;
    private int xp = 0;
    private int queteTermine = 0;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void effectuerUneQuete() {
        this.xp += 10;
        System.out.println("Encore une grande aventure");
        this.queteTermine++;
        this.monteeEnCompetence();
    }

    public void monteeEnCompetence() {
        if (this.xp >= (100 * this.niveau) * this.niveau) {
            this.niveau++;
            this.xp = 0;
            System.out.println("Vous passez niveau " + this.niveau);
            System.out.println("Et vous avez effectuez un total de " + this.queteTermine + " quêtes pour atteindre ce niveau");
            this.queteTermine = 0;
        } else {
            System.out.println("Tue encore des sangliers!");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
