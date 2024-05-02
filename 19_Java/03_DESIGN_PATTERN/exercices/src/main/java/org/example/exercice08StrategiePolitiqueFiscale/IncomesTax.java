package org.example.exercice08StrategiePolitiqueFiscale;

public class IncomesTax implements TaxStrategy {

    @Override
    public double calculateTax(Income income) {
        double result = 0;
        for (int i = 0; i < income.getIncomesEconomicAgent().size(); i++) {
            result += income.getIncomesEconomicAgent().get(i) * 0.10;
        }
        return result;
    }
}
