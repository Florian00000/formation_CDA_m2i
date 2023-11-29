import { Personne } from "./classes.js";

let tablePersonne = [];

let test = new Personne ("Abidbol", "Georges", 55);
tablePersonne.push(test);
console.log(tablePersonne);
console.log(test.nomComplet);

test.nom = "Gustave-Adolphe";
test.nom = "Wayne";
console.log(test.nomComplet);

document.addEventListener("DOMContentLoaded", () => {
    const tableHtml = document.querySelector("table tbody");

    const row = tableHtml.insertRow();

    //Création du tableau avec un for in
    // for (const iterator in test.tablePropietes) {
    //     const cel = row.insertCell();
    //     cel.textContent = test.tablePropietes[iterator];
    //     console.log(test.tablePropietes[iterator]);
    // }

    //Création du tableau avec un map et une fonction fléchée
    test.tablePropietes.map((value) => {row.insertCell().textContent = value})

});
    