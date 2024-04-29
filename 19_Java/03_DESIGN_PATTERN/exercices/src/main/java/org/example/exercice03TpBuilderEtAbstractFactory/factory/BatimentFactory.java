package org.example.exercice03TpBuilderEtAbstractFactory.factory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.AbstractBatimentBuilder;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.Batiment;

public abstract class BatimentFactory {
    public abstract Batiment createBatiment(AbstractBatimentBuilder builder);
}
