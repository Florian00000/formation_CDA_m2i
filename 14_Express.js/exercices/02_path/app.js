
const path = require('path');

//Utilisez la méthode `path.join` pour créer le chemin complet vers un fichier nommé "rapport.txt" dans un répertoire "documents" qui se trouve dans le répertoire utilisateur.
const cheminComplet = path.join(".", "documents", "rapport.txt");


//Utilisez la méthode `path.resolve` pour obtenir le chemin absolu du fichier "rapport.txt" créé précédemment.
const cheminAbsolu = path.resolve(cheminComplet);


console.log("chemin absolu: " +  cheminAbsolu);

//Utilisez la méthode `path.extname` pour vérifier si le fichier a une extension ".txt".
const extension = path.extname(cheminAbsolu);
if (extension == ".txt") {
    console.log("Le fichier à une extension.txt");
}else{
    console.log("Le fichier n' a pas d extension .txt");
}


//Utilisez la méthode `path.dirname` pour obtenir le répertoire du fichier "rapport.txt".
const repertoire = path.dirname(cheminAbsolu);
console.log("répertoire: " + repertoire);

// Utilisez la méthode `path.basename` pour extraire le nom du fichier (sans l'extension) à partir du chemin absolu.
const nomFichier = path.basename(cheminAbsolu, extension)
console.log("Nom du fichier: " + nomFichier);

//Utilisez la méthode `path.parse` pour obtenir un objet avec les détails du chemin du fichier "rapport.txt" (répertoire, base, nom, extension, etc.).
const detailsChemin = path.parse(cheminAbsolu);
console.log("détails du fichiers: ",detailsChemin);

//Utilisez la méthode `path.normalize` pour créer un chemin normalisé à partir de segments relatifs.
const cheminNormalise = path.normalize(cheminAbsolu);
console.log("Chemin normalisé: ", cheminNormalise);