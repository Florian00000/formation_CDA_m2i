package org.example.exercice03TpBuilderEtAbstractFactory.factory;

import org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage.AbstractPersonnageBuilder;
import org.example.exercice03TpBuilderEtAbstractFactory.entity.personnage.Personnage;

public abstract class PersonnageFactory {

    public abstract Personnage createPersonnage(AbstractPersonnageBuilder builder);
}
