package org.example.exercice08StrategiePolitiqueFiscale;

public class Tva implements TaxStrategy{
    @Override
    public double calculateTax(Income income) {
        double result = 0;
        for (int i = 0; i < income.getIncomesEconomicAgent().size(); i++) {
            result += income.getIncomesEconomicAgent().get(i) * 0.20;
        }
        return result;
    }
}
