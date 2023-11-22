let n = parseInt(prompt("Entrez un entier"));
let somme = 0;
let suite = "";
let suiteTemp = `${n}=`;

for (let j = 1; j <= (n/2+1); j++) {
    suiteTemp = `${n}=`; 
    for (let i = j; i <= (n/2+1); i++) {         
        somme += i;
        suiteTemp += `${i}`
        if (somme === n) {

            suite += `${suiteTemp}\n `;                               
                  
        }else{
            suiteTemp += `+`
        } 
    }
    somme = 0;
}

console.log(suite);