package org.example.exercice04;

public class Main {

    public static void main(String[] args) {
        WaterTank citerne1 = new WaterTank(20, 100);
        WaterTank citerne2 = new WaterTank(50, 500);
        WaterTank citerne3 = new WaterTank(20, 50 );

        System.out.println(citerne1.remplissageCiterne(20));
        System.out.println(citerne2.remplissageCiterne(5));

        citerne1.poidsTotal();
        System.out.println(citerne1.viderCiterne(5));
        citerne1.poidsTotal();

        WaterTank.getTotalCiternesEau();

        System.out.println(citerne3.remplissageCiterne(5));
        WaterTank.getTotalCiternesEau();
        System.out.println(citerne3.viderCiterne(10));
        WaterTank.getTotalCiternesEau();
    }
}
