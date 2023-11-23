const normalisation = function (chaine) {
    return chaine.trim().toLowerCase();
}

const verificationAdn = function (chaine) {
    chaine = chaine.trim().toLowerCase();
    for (let i = 0; i < chaine.length; i++) {
        if ((chaine[i] != "a") && (chaine[i] != "t") && (chaine[i] != "c") && (chaine[i] !="g")) {
            return false
        }        
    }
    return true
}

//Demande à l'utilisateur une chaine d'ADN Jusqu'a ce qu'il en rentre une correcte. (Prend en param la fonction verificationAdn)
const saisieAdn = function (fonction) {   
    
    let saisie = prompt("Balance ton adn");
    while (fonction(saisie) === false) {
        alert("Erreur de saisie!!!");
        saisie = prompt("Balance ton adn");
    }

    return saisie.trim().toLowerCase();
}

const proportion = function(chaine, sequence) {
    chaine = normalisation(chaine);
    sequence = normalisation(sequence);

    let compteur = 0;
    for (let i = 0; i < chaine.length; i++) {
        if (chaine.substring(i, (i + sequence.length)) === sequence) {
            compteur++  ;
        }        
    }
    let res = (compteur * sequence.length *  100) / (chaine.length);
    return res
}

console.log(proportion("actgactgaa", "actgactg"));

// console.log(saisieAdn(verificationAdn));

