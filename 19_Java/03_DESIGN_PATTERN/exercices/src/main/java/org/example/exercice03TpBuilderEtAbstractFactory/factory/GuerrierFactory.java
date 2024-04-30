package org.example.exercice03TpBuilderEtAbstractFactory.factory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage.AbstractPersonnageBuilder;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage.Personnage;

public class GuerrierFactory extends PersonnageFactory {
    @Override
    public Personnage createPersonnage(AbstractPersonnageBuilder builder) {
        return builder.build();
    }
}
