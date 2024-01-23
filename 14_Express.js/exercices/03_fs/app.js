const path = require('path');
const fs = require('fs');



//Créer un répertoire :** Utiliser `fs.mkdir` pour créer un répertoire appelé "nouveau_repertoire".

if (!fs.existsSync("nouveau_repertoire")) {
    
    fs.mkdir("nouveau_repertoire", (err) => {
        if (err) throw err;
        console.log("Répertoire créé avec succès!");
    });
}



//Écrire dans un fichier :** Utiliser `fs.writeFile` pour écrire le texte "Contenu du fichier à écrire." dans un fichier appelé "nouveau_fichier.txt".
const cheminNormalise = path.normalize("nouveau_repertoire/nouveau_fichier.txt")

if (!fs.existsSync(cheminNormalise)) {
    
    fs.writeFile(cheminNormalise, "Contenu du fichier à écrire.", 'utf8', (err, data) => {
        if (err) throw err; console.log("Le fichier a été enregistré");
    });
}



//Lire le contenu du fichier :** Utiliser `fs.readFile` pour lire le contenu du fichier "nouveau_fichier.txt" et afficher le résultat dans la console.    


fs.readFile(cheminNormalise, 'utf8', (err, data) => {
    if (err) throw err; console.log("Voici le contenu du fichier: ", data);
});



//Lister les fichiers du répertoire :** Utiliser `fs.readdir` pour lister tous les fichiers et répertoires dans le répertoire actuel et afficher le résultat dans la console.
setTimeout(()=> {
    fs.readdir(".", (err, files) => {
        if (err) throw err;
        console.log("Contenu du répertoire: ", files);
    });
    
}, 500)

//Supprimer le fichier :** Utiliser `fs.unlink` pour supprimer le fichier "nouveau_fichier.txt".

setTimeout(()=> {
    fs.unlink(cheminNormalise, (err) => {
        if (err) throw err;
        console.log("Fichier supprimé avec succès!");
    });
    
}, 500)

//Supprimer le répertoire :** Utiliser `fs.rmdir` pour supprimer le répertoire "nouveau_repertoire".

setTimeout(() => {

    fs.rmdir("nouveau_repertoire", (err) => {
        if (err) throw err;
        console.log("Le dossier a été supprimé avec succès");
    })
}, 500)

