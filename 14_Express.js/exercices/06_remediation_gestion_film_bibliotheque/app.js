//====================Import====================
//instanciation d'Express
const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;


//Import de la connexion à la BDD MySQL
const connection = require('./config/db.js');
const connect = connection;

//bodyparser
const bodyParser = require('body-parser');
app.use(bodyParser.json());

//====================Routers====================
const livreRoute = require('./src/routes/livreRoute.js');

app.use('/livres', livreRoute);


//====================On lance le serveur====================
app.listen(PORT, () => {
    console.log(`serveur en route sur le port ${PORT}`);
})