function soustraire(a, b) {
    // a = parseInt(a);
    // b = parseInt(b);
    console.log(`Je soustrais ${a} et ${b}`);
    return a - b;
}

console.log(soustraire(parseInt(prompt("Entrez un premier nombre entier")), parseInt(prompt("Entrez un second nombre entier"))));