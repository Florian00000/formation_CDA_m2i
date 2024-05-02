package org.example.exercice08StrategiePolitiqueFiscale;

public class EconomicModel {

    private TaxStrategy taxStrategy;

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double testEconomicStrategy(Income income){
        return taxStrategy.calculateTax(income);
    }
}
