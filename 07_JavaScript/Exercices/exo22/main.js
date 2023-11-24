let n = parseInt(prompt("Entrez le nombre de chiffre que comportera le tableau"));

const aleatoire = () => {
    return Math.round((Math.random() * (50 - 1) + 1))
} 

const creeTableau = function (taille) {
    let table = [];
    for (let i = 0; i < taille; i++) {        
        table[i] = aleatoire();
    }
    return table;
}

let table = creeTableau(n);
console.table(table);

const verifTableau = function(tableau) {    
    let reponse = "";    
    for (let i = 0; i < tableau.length; i++) { 
        (tableau[i] % 2 === 0) ? ((tableau[i] < 10) ? reponse += `le nombre  ${tableau[i]} est   pair\n` : reponse += `le nombre ${tableau[i]} est   pair\n`) 
        : ((tableau[i] < 10) ? reponse += `le nombre  ${tableau[i]} est impair\n` : reponse += `le nombre ${tableau[i]} est impair\n`);
        
        //     reponse += `le nombre ${tableau[i]} est pair\n`;
        // } else {
        //     reponse += `le nombre ${tableau[i]} est impair\n`;
        // }
    }    
    return reponse;
}

console.log(verifTableau(table));