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
        if (value === "Gustave-Adolphe") {
            console.log("Ce nom n'est pas accessible");
        } else {
            this.#nom = value;            
        }
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

    get nomComplet () {
        return `${this.#prenom} ${this.#nom}`
    }

    get tablePropietes () {
        return [
            this.#nom,
            this.#prenom,
            this.#dateNaissance
        ]
    }
}