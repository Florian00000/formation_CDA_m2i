const palindrome = function (mot) {
    let tabI = [];
    let inverse = "";    

    for (let i = 0; i < mot.length; i++) {  
        tabI[mot.length - (i + 1)] = mot[i];    
    }
    
    for (let i = 0; i < mot.length; i++) {
        inverse += tabI[i].toString();        
    }

    return inverse;
}

// console.log(palindrome(mot));

const verifPalindrome = function (mot, fonction) {
    mot = mot.trim().toLowerCase(); //normaliser le mot
    let palindrome = fonction(mot);
    if (mot === palindrome) {
        return true;
    } else {
        return false
    }
}

let mot1 = "pierre";
let mot2 = "kayak";

console.log(mot1);
console.log(verifPalindrome(mot1 , palindrome));
console.log(mot2);
console.log(verifPalindrome(mot2 , palindrome));

const verif2 = function(mot) {
    mot = mot.trim().toLowerCase(); //normaliser le mot    
    for (let i = 0; i < mot.length; i++) {  
        if ((mot[mot.length - (i + 1)]) !== (mot[i])) {
            return false;
        }            
    }
    return true;
}

console.log("version 2");
console.log(mot1);
console.log(verif2(mot1));
console.log(mot2);
console.log(verif2(mot2));