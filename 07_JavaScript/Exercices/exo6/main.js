let age = Number(prompt("Entrez votre âge"));
let salaire = Number (prompt("Entrez le salaire attendu"));
let xp = Number (prompt("Entrez votre nombre d'années d'expérience"));
let isAccepted = true;

if (age < 30) {
    console.log("Vous n'avez pas l'âge requis");
    isAccepted = false;
}
if (salaire > 40000) {
    console.log("Le salaire demandé est trop élevé");
    isAccepted = false;
}
if (xp < 5) {
    console.log("Vous n'avez pas assez d'expériences");
    isAccepted = false;
}

if (isAccepted === true) {
    console.log("Vous êtes acceptés");
}
