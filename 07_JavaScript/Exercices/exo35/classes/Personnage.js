export default class Personnage {
    nom;
    vie;
    force;

    constructor (nom, vie, force) {
        this.nom = nom;
        this.vie = vie;
        this.force = force;
    }

    attaquer(personnage) {
        personnage.vie -= this.force;
        console.log(`${this.nom} inflige ${this.force} à ${personnage.nom}!`);
    }    

}