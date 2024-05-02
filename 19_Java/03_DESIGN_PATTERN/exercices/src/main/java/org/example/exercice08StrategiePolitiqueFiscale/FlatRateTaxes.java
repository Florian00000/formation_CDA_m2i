package org.example.exercice08StrategiePolitiqueFiscale;

public class FlatRateTaxes implements TaxStrategy{
    @Override
    public double calculateTax(Income income) {
        return 0;
    }
}
