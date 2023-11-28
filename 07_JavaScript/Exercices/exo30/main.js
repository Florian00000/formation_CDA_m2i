import { Chien } from "./chien.js";
import Chat from "./chat.js";

let tableauAnimaux = [];

//On créé les objets à l'aide des constructeurs
const chien1 = new Chien("Rex", "berger");
const chat1 = new Chat("Felix");


//On remplit le tableau des animaux
tableauAnimaux.push(chien1);
tableauAnimaux.push(chat1);

console.log(tableauAnimaux);

document.addEventListener("DOMContentLoaded", () => {
    const tableau = document.getElementById("tableau");
    const form = document.getElementById("form");
    const nomAnimal = document.getElementById("nom");
    const raceAnimal = document.getElementById("race");

    form.addEventListener("submit", (event) => {
        event.preventDefault;

        const row = tableau.insertRow();
        for (const key in chien1) {
            const cel = row.insertCell();
            cel.textContent = chien1[key];
        }
    });

});