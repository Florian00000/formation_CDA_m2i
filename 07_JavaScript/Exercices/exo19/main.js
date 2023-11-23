const compterLettreA = function (phrase) { 
    let compteur = 0;   
    for (let i = 0; i < phrase.length; i++) {  
        if ((phrase[i] == "a") || (phrase[i] == "A")) {
            compteur++;
        }            
    }
    return compteur;
}

console.log(compterLettreA("kayak"));
console.log(compterLettreA("mixer"));