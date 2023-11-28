export class Personne {
    #nom;
    #prenom;
    #dateNaissance;

    constructor (nom, prenom, dateNaissance) {
        this.#nom = nom;
        this.#prenom = prenom;
        this.#dateNaissance = dateNaissance;
    }

    //getter et setters
    get nom () {
        return this.#nom
    }

    set nom (value) {
        this.#nom = value;
    }

    get prenom () {
        return this.#prenom
    }

    set prenom (value) {
        this.#prenom = value;
    }

    get dateNaissance () {
        return this.#dateNaissance
    }

    set dateNaissance (value) {
        this.#dateNaissance = value;
    }
}