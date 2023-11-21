let epaisseur = 0.1;
let compteur = 0; 

while (epaisseur <= 400000) {
    epaisseur *= 2;
    compteur++;
}

console.log(`Il faut plier la feuille ${compteur} fois.`);

console.log("2e version");

epaisseur = 400000;
compteur = 0 ;
while (epaisseur >= 0.1) {
    epaisseur /= 2;
    compteur++;
}

console.log(`Il faut déplier la feuille ${compteur} fois.`);