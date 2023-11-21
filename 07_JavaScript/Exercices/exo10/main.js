let n = parseInt(prompt("Entrez la hauteur du sapin"));
let etoiles = "*";
let espaces = " ";
let nbEspaces = n -1;

for (let i = 1; i <= n; i++) {   
    
    console.log(`${espaces.repeat(nbEspaces)}${etoiles}`);
    etoiles += "**";     
    nbEspaces --;
}

