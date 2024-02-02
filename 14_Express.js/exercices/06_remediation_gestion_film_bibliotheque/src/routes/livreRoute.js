const express = require('express');
const router = express.Router();
const livreController = require('../controllers/livreController');

//définition des routes
router.get('/', livreController.getAllLivres);
router.post('/addLivre', livreController.addLivre);
router.put('/updateLivre/:id', livreController.updateLivre);
router.delete('/deleteLivre/:id', livreController.deleteLivre);

//On exporte les routes
module.exports = router;