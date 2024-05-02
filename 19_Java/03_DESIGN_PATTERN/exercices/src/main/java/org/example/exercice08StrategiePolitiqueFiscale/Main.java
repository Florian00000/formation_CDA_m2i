package org.example.exercice08StrategiePolitiqueFiscale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Income income = new Income();
        EconomicModel economicModel = new EconomicModel();

        Scanner scanner = new Scanner(System.in);
        int choix = 4;

        do {
            System.out.println("Sélection de la stratégie fiscale");
            System.out.println("Taper 0 pour quitter la simulation");
            System.out.println("taper 1 pour pour impôt sur le revenu progressif");
            System.out.println("taper 2 pour TVA ");
            System.out.println("taper 3 pour impôt forfaitaire");
            choix = Integer.parseInt(scanner.nextLine());
            switch (choix) {
                case 0:
                    System.out.println("A la prochaine");
                    break;
                case 1 :
                    economicModel.setTaxStrategy(new IncomesTax());
                    System.out.println("gain attendu: " + economicModel.testEconomicStrategy(income) + " €");                    ;
                    break;
                case 2 :
                    economicModel.setTaxStrategy(new Tva());
                    System.out.println("gain attendu: " + economicModel.testEconomicStrategy(income) + " €");
                    break;
                case 3 :
                    economicModel.setTaxStrategy(new FlatRateTaxes());
                    System.out.println("gain attendu: " + economicModel.testEconomicStrategy(income) + " €");
                    break;
                default :
                    System.out.println("Entrée incorrect");
                    break;
            }
        }while (choix != 0);
    }
}
