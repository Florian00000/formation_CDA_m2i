const firstname = "John";

const monTableau = [1, 2, 3, 4, 5];

console.log(monTableau);

for (const element of monTableau) {
  console.log(element);
}

// Pour créer un objet, on va utiliser la notation des accolades en cas de création simple
const monObjet = {
  firstName: "John",
  lastName: "DUPONT",
};

// On peut parcourir une par une les clés de notre objet, et récupérer les valeurs via la notation 'varObj[clé]'
for (const key in monObjet) {
  console.log(monObjet[key]);
}

monObjet.age = 24;

console.log(monObjet.lastName);
console.log(monObjet["lastName"]);

monObjet.age = 25;

console.log(monObjet);

// const maCle = prompt('Quelle clé ?')

// console.log(monObjet.maCle); non dynamique
// console.log(monObjet[maCle]); dynamique

const [blabla, truc, ...reste] = monTableau;
console.log(reste);

let varA = "varA";
let varB = "varB";

console.log(`AVANT - varA: ${varA}, varB: ${varB}`);

[varA, varB] = [varB, varA];

console.log(`APRES - varA: ${varA}, varB: ${varB}`);

let otherObj = {
  a: 1,
  b: 2,
  c: 3,
};

console.log(otherObj);

otherObj = {
  ...otherObj,
  d: 4,
  e: 5,
};

const { b: trucMuche, a, ...toto } = otherObj;
console.log(trucMuche);
console.log(toto);

console.log("b" in otherObj);

const mesPersonnes = [];

const newPersonne = {
  firstname: "John",
  lastname: "DUPONT",
  birthDate: "11/12/2023",
};

mesPersonnes.push(newPersonne);
mesPersonnes.push(newPersonne);

console.log(mesPersonnes);
