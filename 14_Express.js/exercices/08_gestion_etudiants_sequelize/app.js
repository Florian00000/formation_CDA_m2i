const express = require('express');
require('dotenv').config();
const DB = require("./config/db");

const app = express();
const port = 3000;

const userRoutes = require("./src/routes/userRoutes");
const etudiantRoutes = require("./src/routes/etudiantRoutes");

//middleware pour vérifier que la personne est connecté
const isAuthenticated = require('./src/middlewares/authentification');

app
.use(express.json())
.use("/api/user", userRoutes)
.use("/api/etudiant", isAuthenticated, etudiantRoutes);

DB.sequelize
    .authenticate()
    .then(() => console.log("Connexion avec la BDD réussie"))
    .then(() => {
        app.listen(port, () => {
            console.log(`http://localhost:${port}`);
        });
    })
    .catch((err) => {
        console.log("Erreur lors de la connexion à la BDD", err.message);
    });