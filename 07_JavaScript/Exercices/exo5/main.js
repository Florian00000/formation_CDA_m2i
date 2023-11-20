let temp = Number(prompt("Entrez la valeur de la température de l'eau"));

// if (temp < 0) {
//     console.log("L'eau est à l'état solide");
// } else if (temp <= 100) {
//     console.log("L'eau est à l'état liquide");
// } else if (temp > 100) {
//     console.log("L'eau est à l'état gazeux");
// } else {
//     console.log("Entrez une valeur numérique");
// }

let etat = (temp < 0) ? "L'eau est à l'état solide": ((temp <= 100) ? "L'eau est à l'état liquide" : ((temp > 100) ? "L'eau est à l'état gazeux" : "Entrez une valeur numérique"));
console.log(etat);