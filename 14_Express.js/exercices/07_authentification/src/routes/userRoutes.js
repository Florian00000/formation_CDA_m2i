const express = require('express');
const userController = require('../controllers/userController');

const router = express.Router();

const isAuthenticated = require('../middlewares/authentification');

router.post("/signup", userController.signup);
router.post("/login", userController.login);
//L'utilisateur a accès au profile que si il est connecté
router.get("/profile",isAuthenticated , userController.profile)

module.exports = router;