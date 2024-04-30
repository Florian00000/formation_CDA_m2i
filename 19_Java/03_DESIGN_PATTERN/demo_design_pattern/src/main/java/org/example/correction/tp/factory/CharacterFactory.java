package org.example.correction.tp.factory;

import org.example.correction.tp.entity.AbstractCharacterBuilder;
import org.example.correction.tp.entity.Character;

public abstract class CharacterFactory {

    public abstract Character createCharacter(AbstractCharacterBuilder builder);
}
