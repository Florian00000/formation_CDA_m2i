package org.example.exercice08StrategiePolitiqueFiscale;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Income {

    private List<Double> incomesEconomicAgent = new ArrayList<>();

    public List<Double> getIncomesEconomicAgent() {
        return incomesEconomicAgent;
    }

    public Income() {
        for (int i = 0; i < 10; i++) {
            this.incomesEconomicAgent.add(new Random().nextDouble(1000, 10000));
        }

    }
}
