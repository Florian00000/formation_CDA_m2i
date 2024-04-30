package org.example.correction.tp.factory;

import org.example.correction.tp.entity.*;
import org.example.correction.tp.entity.Character;

public class WarriorFactory extends CharacterFactory {

    @Override
    public Warrior createCharacter(AbstractCharacterBuilder builder) {
        return (Warrior) builder.build();
    }
}
