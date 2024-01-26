const Livre = require('../models/livre');

const livreController = {
    getAllLivres: (req, res) => {
        Livre.getAllLivres((err, livres) => {
            if(err) throw err;
            res.json(livres);
        });
    },

    //ne fonctionne pas encore
    addLivre: (req, res) => {
        const livreData = req.body;
        Livre.addLivre(livreData, (err, result) => {
            if (err) throw err;
            res.send('Le livre a été ajouté avec succès')
        });
    }
}

module.exports = livreController;