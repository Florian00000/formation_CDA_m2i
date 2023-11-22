function toTitle(nom) {
    nom = nom.toLowerCase();
    return `${nom.charAt(0).toUpperCase()}${nom.substring(1)}`;
}

function np(prenom, nom) {    
    return `${toTitle(prenom)} ${toTitle(nom)}`
}

console.log(np(prompt("entrez votre prénom"), prompt("entrez votre nom")));
