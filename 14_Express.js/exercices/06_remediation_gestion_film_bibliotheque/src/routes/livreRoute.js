const express = require('express');
const router = express.Router();
const livreController = require('../controllers/livreController');

//définition des routes
router.get('/', livreController.getAllLivres);
//ne fonctionne pas encore
router.post('/addLivre', livreController.addLivre);

//On exporte les routes
module.exports = router;