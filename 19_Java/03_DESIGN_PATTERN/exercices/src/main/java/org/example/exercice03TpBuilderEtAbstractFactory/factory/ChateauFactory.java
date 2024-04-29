package org.example.exercice03TpBuilderEtAbstractFactory.factory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.AbstractBatimentBuilder;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.Batiment;

public class ChateauFactory extends BatimentFactory {

    @Override
    public Batiment createBatiment(AbstractBatimentBuilder ChateauBuilder) {
        return ChateauBuilder.build();
    }
}
