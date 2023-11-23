let tab = [];
let tabulation = "\t"; 

const aleatoire = () => {
    return Math.round((Math.random() * 100))
} 

//version avec demande de saisie
// for (let i = 0; i < 10; i++) {
//     tab[i] = prompt(`Entrez une ${i + 1}e valeur`)    
// }

//seconde version
for (let i = 0; i < 10; i++) {
    tab[i] = aleatoire();    
}

for (let i = 0; i < tab.length; i++) {
    console.log(`${tabulation.repeat(i)} ${tab[i]}`);    
}
