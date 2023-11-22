let mot = "pierre";
let test = [];
let inverse = "";

for (let i = 0; i < mot.length; i++) {    
    test[mot.length - i] = mot[i];
    
}

for (let i = 0; i < test.length; i++) {    
    inverse += `${test[mot.length - i]}`;
}

console.log(test);
console.log(inverse);
