package org.example.correction.tp;

import org.example.correction.tp.entity.Building;
import org.example.correction.tp.entity.Character;

import java.util.List;

public class GameManager {

    private List<Building> buildings;
    private List<Character> characters;

    public void addBuilding(Building building) {
        buildings.add(building);
        checkUnlockables();
    }

    public void addCharacter(Character character) {
        characters.add(character);
        checkUnlockables();
    }

    private void checkUnlockables() {

    }

    private void unlockCharacter(String characterType) {

    }

    private void unlockEquipment(String equipment, String characterType) {
        
    }
}
