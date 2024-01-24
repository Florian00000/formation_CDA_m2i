const express = require("express")
const router = express.Router();

const path = require('path');
const fs = require('fs');

//data
const listLivres = path.join("data", "livres.json");  
const jsonLivres = fs.readFileSync(listLivres, 'utf8');
const tableLivre = JSON.parse(jsonLivres);


//liste livres
router.get('/', (req, res) => {
    res.json(tableLivre)        
});

//détails
router.get('/:id', (req, res) => {
    const livreId = req.params.id;    
    res.json(tableLivre[livreId - 1])
} )

//Ajout d'un nouveau livre
router.post('/ajout-livre', (req, res) => {
    const nbLivres = tableLivre.length;
    
    //création de l'objet simulé
    const nouveauLivre = {
        id: nbLivres + 1,
        titre: "test",
        auteur: "testauteur"
    }
    
    
    //ajout de l'objet à la liste des livres
    tableLivre.push(nouveauLivre);    
    
    console.log(tableLivre);
    res.status(201).json(nouveauLivre)
})

// Recherche de livres par auteur
router.get('/auteur/:nomAuteur', (req, res) => {
    const nomAuteur = req.params.nomAuteur
    const livresAuteur = [];
    for (let index = 0; index < tableLivre.length; index++) {
        //j'aime pas les regex        
        if (nomAuteur.toLowerCase() == tableLivre[index].auteur.replaceAll(" ", "").replaceAll(".", "").toLowerCase()) {
            livresAuteur.push(tableLivre[index])
        }
    }
    console.log(tableLivre);
    res.json(livresAuteur)
})

//On exporte le module
module.exports = router;
