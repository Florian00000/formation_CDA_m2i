let pop = parseInt(prompt("Entrez la population initiale"));
let popVise = parseInt(prompt("Entrez la population visée"));
let taux = parseInt(prompt("Entrez le taux"));
taux = 1 + (taux/100);
let annee = 0;

while (pop <= popVise) {
    pop *= taux;
    annee++;
}

console.log(`Il faudra ${annee} pour que atteindre la population visée (${popVise}), avec une population toale dde ${Math.round(pop)}`);