package org.example.correction.tp.entity;

public class Warrior extends Character {

    private int armor;

    private Warrior(WarriorBuilder warriorBuilder) {
        super(warriorBuilder);
        this.armor = warriorBuilder.armor;
    }

    public static class WarriorBuilder extends AbstractCharacterBuilder {
        private int armor;
        public WarriorBuilder armor(int armor) {
            this.armor = armor;
            return this;
        }
        @Override
        public Character build() {
            return new Warrior(this);
        }
    }
}
