import Chat from './classes/Chat.js';
import Chien from './classes/Chien.js';

// Ces deux syntaxes sont équivalentes
// Tout objet JavaScript hérite de Object
let monObjet = {};
let monSecondObjet = new Object();

let garfield = new Chat("Garfield", 12, "Pelote");

garfield.crier();

let medor = new Chien("Médor", 5);

medor.crier();


function Personne(nom, prenom, email) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
}

// Héritage avant ES6
Personne.prototype.sayHello = function() {console.log("Hello")};

function Salarie(nom, prenom, email, salaire) {
    Personne.call(this, nom, prenom, email);
    this.salaire = salaire;
}

// Copie le constructeur de Personne
Salarie.prototype = Object.create(Personne.prototype);

let monSalarie = new Salarie("Dupont", "Jean", "jean@dupont.fr", 3000);

monSalarie.sayHello();