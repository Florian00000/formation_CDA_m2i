package org.example.exercice03TpBuilderEtAbstractFactory.factory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.AbstractBatimentBuilder;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.Batiment;

public class CaserneFactory extends BatimentFactory{
    @Override
    public Batiment createBatiment(AbstractBatimentBuilder caserneBuilder) {
        return caserneBuilder.build();
    }
}
