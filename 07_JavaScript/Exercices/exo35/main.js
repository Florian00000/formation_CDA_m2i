// import Personnage from "./classes/Personnage.js";
import Guerrier from "./classes/Guerrier.js";
import Magicien from "./classes/Magicien.js";

let ragnar = new Guerrier ("Ragnar", 10, 5, 2);
let gandalf = new Magicien ("Gandalf", 25 , 2, 5);

console.log(ragnar);
console.log(gandalf);

ragnar.attaquer(gandalf);

console.log(gandalf);

gandalf.attaquer(ragnar);
console.log(ragnar);

gandalf.soigner(gandalf);
console.log(gandalf);