//====================Import====================
//instanciation d'Express
const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;


//Import de la connexion à la BDD MySQL
const connection = require('./config/db.js');
const connect = connection;

//connexion à mongoDB avec mongose
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/express_film_bibliotheque');

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB: '));
db.once('open', () => {
    console.log('Connecté à MongoDB');
}); // Ces lignes gèrent les événements liés à la connexion MongoDB. En cas d'erreur, un message est affiché dans la console. Si la connexion est établie avec succès, le message "Connecté à MongoDB" est affiché une fois.

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