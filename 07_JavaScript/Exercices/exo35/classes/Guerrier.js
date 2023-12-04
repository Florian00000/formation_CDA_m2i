import Personnage from "./Personnage.js";

export default class Guerrier extends Personnage {
    armure;

    constructor (nom, vie, force, armure) {
        super (nom, vie, force);
        this.armure = armure;
        this.vie += this.armure;
    }

    attaquer(personnage) {
        personnage.vie -= (this.force + this.armure);
        console.log(`${this.nom} inflige ${this.force + this.armure} à ${personnage.nom}!`);
    }
    
}