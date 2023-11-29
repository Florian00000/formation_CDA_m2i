export class Musique {
    id;
    nom;
    artiste;
    annee;

    static count = 0;

    constructor (nom, artiste, annee) {
        this.id = ++Musique.count;
        this.nom = nom;
        this.artiste = artiste;
        this.annee = annee;
    }

    get id () {
        return this.id;
    }
}