let n = parseInt(prompt("Entrez un entier entre 1 et 10"));
let message = "";

for (let i = 1; i <= n; i++) {
    console.log("Table des " + i + ":");
    for (let j = 1; j <= 10; j++) {
        console.log(`${i} * ${j} = ${i * j}`);
        
    }
    console.log("\n");
}

console.log("2e version");
console.log("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
console.log("-------------------------------------------------------------------------------");
for (let i = 1; i <= n; i++) {    
    // console.log(`${1 * i}\t${2 * i}\t${3 * i}\t${4 * i}\t ${5 * i}\t${6 * i}\t ${7 * i}\t${8 * i}\t${9 * i}\t${10 * i}`);
    for (let j = 1; j <= 10; j++) {
        message += `${i * j}\t`        
    }    
    message += "\n";
}
console.log(message);