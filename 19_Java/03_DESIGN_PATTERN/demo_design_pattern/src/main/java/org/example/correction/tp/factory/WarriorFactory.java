package org.example.correction.tp.factory;

import org.example.correction.tp.entity.AbstractBuildingBuilder;
import org.example.correction.tp.entity.AbstractCharacterBuilder;
import org.example.correction.tp.entity.Building;
import org.example.correction.tp.entity.Character;

public class WarriorFactory extends CharacterFactory {

    @Override
    public Character createCharacter(AbstractCharacterBuilder builder) {
        return builder.build();
    }
}
