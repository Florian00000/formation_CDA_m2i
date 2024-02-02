const Livre = require('../models/livre');

const livreController = {
    getAllLivres: (req, res) => {
        Livre.getAllLivres((err, livres) => {
            if(err) throw err;
            res.json(livres);
        });
    },
    
    addLivre: (req, res) => {
        const livreData = req.body;
        Livre.addLivre(livreData, (err, result) => {
            if (err) throw err;
            res.send('Le livre a été ajouté avec succès')
        });
    },

    updateLivre: (req, res) => {
        const livreId = req.params.id;
        const livreData = req.body;
        Livre.updateLivre(livreId, livreData, (err, result) => {
            if (err) throw err;
            if (result.affectedRows === 0) {
                res.status(404).send('Livre non trouvé. Aucune mise à jour effectuée.')
            }else{
                res.send('Livre mis à jour avec succès');
            }
        })
    },

    deleteLivre: (req, res) => {
        const livreId = req.params.id;
        Livre.deleteLivre(livreId, (err, result) => {
            if (err) throw err;
            if (result.affectedRows === 0) {
                res.status(404).send('Livre non trouvé. Aucun livre supprimé.')
            }else{
                res.send('Livre Supprimé avec succès')
            }
        })
    }
}

module.exports = livreController;