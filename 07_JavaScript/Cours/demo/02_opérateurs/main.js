// Les Opérateurs Arithmétiques

// Déclaration variables à la volée
let nb1 = 10, nb2 = 65, resultat;

// L'addition
resultat = nb1 + nb2
console.log(nb1 + " + " + nb2 + " = " + resultat)
console.log(`${nb1} + ${nb2} = ${resultat}`);

// Soustraction
resultat = nb1 - nb2
console.log(nb1 + " - " + nb2 + " = " + resultat)
console.log(`${nb1} - ${nb2} = ${resultat}`);

// Multiplication
resultat = nb1 * nb2
console.log(nb1 + " x " + nb2 + " = " + resultat)
console.log(`${nb1} x ${nb2} = ${resultat}`);

// Division
resultat = nb1 / nb2
console.log(nb1 + " / " + nb2 + " = " + resultat)
console.log(`${nb1} / ${nb2} = ${resultat}`);

// Modulo (reste de la division)
resultat = nb1 % nb2
console.log(nb1 + " % " + nb2 + " = " + resultat)
console.log(`${nb1} % ${nb2} = ${resultat}`);

// Puissance
resultat = nb1 ** nb2
console.log(nb1 + " puissance " + nb2 + " = " + resultat)
console.log(`${nb1} puissance ${nb2} = ${resultat}`);


console.log("Les opérateurs d'incrémentation et combinés")

// Incrementation
nb1 = nb1 + 1 // Incrementation classique
console.log(" nb1 vaut : "+ nb1); // 11
// operateur combiné +=
nb1 += 1
console.log(" nb1 vaut : "+ nb1); // 12
// operateur d'incrementation
console.log(nb1++); // 12
console.log(" nb1 vaut : "+ nb1); // 13


// Decrementation
nb1 = nb1 - 1 // Incrementation classique
console.log(" nb1 vaut : "+ nb1); // 12
// operateur combiné -=
nb1 -= 1
console.log(" nb1 vaut : "+ nb1); // 11
// operateur d'incrementation
console.log(nb1--); // 11
console.log(" nb1 vaut : "+ nb1); // 10

console.log("Détail operateurs -- et ++")

// Précision pour les Operateurs ++ et --
console.log(nb1); // 10
// Incrementation puis lecture de la valeur (préincrementation)
console.log(++nb1); // 11
// Decrementation puis lecture de la valeur (predecrementation)
console.log(--nb1); // 10
// lecture de la valeur puis => incrementation (postincrementation)
console.log(nb1++); // 10
console.log(nb1); // 11
// lecture de la valeur puis => decrementation (preincrementation)
console.log(nb1--); // 11
console.log(nb1); // 10


// OPERATEURS BOOLÉENS

// Opérateur de comparaison

// Égalité
console.log("Egalité 3 == 3 ", 3 == 3) //T
console.log("Egalité \"3\" == 3 ", "3" == 3) //T
console.log("Egalité 3 == 4 ", 3 == 4) //F

// Inégalité
console.log("Inégalité 3 != 3 ", 3 != 3) //F
console.log("Inégalité 3 != 4 ", 3 != 4) //T

// Égalité stricte (vérifie le type)
console.log("Egalité stricte \"3\" === 3 ", "3" === 3) //F
console.log("Egalité stricte 3 === 3 ", 3 === 3) //T

// Inégalité stricte 
console.log("Inégalité stricte \"3\" !== 3 ", "3" !== 3) //F
console.log("Inégalité stricte 3 !== 4 ", 3 !== 4) //T

// Supériorité stricte 
console.log("Egalité 3 > 3 ", 3 > 3) //F
console.log("Egalité 3 > 4 ", 3 > 4) //F

// Supériorité 
console.log("Egalité 3 >= 3 ", 3 >= 3) //T
console.log("Egalité 3 >= 4 ", 3 >= 4) //F

// Infériorité stricte 
console.log("Egalité 3 < 3 ", 3 < 3) //F
console.log("Egalité 3 < 4 ", 3 < 4) //T

// Infériorité
console.log("Egalité 3 <= 3 ", 3 <= 3) //T
console.log("Egalité 3 <= 4 ", 3 <= 4) //T


// opérateurs logiques

// ET
console.log("Vrai ET Vrai", true && true) //T
console.log("Vrai ET Faux", true && false) //F
console.log("Faux ET Faux", false && false) //F


// OU
console.log("Vrai OU Vrai", true || true) //T
console.log("Vrai OU Faux", true || false) //T
console.log("Faux OU Faux", false || false) //F


// NON
console.log("NON Vrai", !true) //F
console.log("NON Faux", !false) //T

// console.log((true && (false || ( 5 === "5"))) || (6 < 7) )
// console.log((true && (false ||    false    )) ||  true   )
// console.log((true &&       false            ) ||  true   )
// console.log(      false                       ||  true   )
// console.log(                                 true        )