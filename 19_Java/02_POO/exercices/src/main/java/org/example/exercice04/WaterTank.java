package org.example.exercice04;

public class WaterTank {

    private final int poidsVide;
    private final int capacite;
    private int remplissage = 0;
    private static int totalCiternesEau = 0;

    public WaterTank (int poidsVide, int capacite){
        this.poidsVide = poidsVide;
        this.capacite = capacite;
    }

    public static int getTotalCiternesEau() {
        System.out.println("Quantitée d'eau dans toutes les citernes: " + totalCiternesEau);
        return totalCiternesEau;
    }

    public int poidsTotal(){
        System.out.println("Poids total de la citerne: " + (poidsVide + remplissage));
        return poidsVide + remplissage;
    };

    public int remplissageCiterne(int litres){
        this.remplissage+= litres;
        totalCiternesEau+= litres;
        int exces = 0;
        if (this.remplissage > this.capacite){
            exces = this.remplissage - this.capacite;
            this.remplissage = this.capacite;
            totalCiternesEau-= exces;
        }
        System.out.println("Quantité d'eau dans la citerne après ajout de "
                + litres + " litre(s): "
                + this.remplissage + "/" + this.capacite);
        return exces;
    }

    public int viderCiterne(int litres){
        this.remplissage-= litres;
        totalCiternesEau-= litres;
        int negatif = 0;
        if (this.remplissage < 0) {
            negatif = this.remplissage * -1;
            this.remplissage = 0;
            totalCiternesEau+= negatif;
        }
        System.out.println("Quantité d'eau dans la citerne après prélèvement de "
                + litres + " litre(s): "
                + this.remplissage + "/" + this.capacite);
        return negatif;
    }
}
