import Personnage from "./Personnage.js";

export default class Magicien extends Personnage {
    mana;

    constructor (nom, vie, force, mana) {
        super (nom, vie, force);
        this.mana = mana;
        
    }

    attaquer(personnage) {
        personnage.vie -= (this.force + this.mana);        
        console.log(`${this.nom} inflige ${this.force + this.mana} à ${personnage.nom}!`);
    }

    soigner(personnage) {
        personnage.vie += this.mana;
        console.log(`${this.nom} soigne ${personnage.nom}`);
    }
    
}