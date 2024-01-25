const express = require('express');
const path = require('path');


const app = express();
const PORT = process.env.PORT || 3000;

const connection = require('./config/db.js')

const connect = connection;

// Définir le dossier public pour les fichiers statiques
app.use(express.static('public'));


//configuration template pug
app.set('view engine', 'pug') 
app.set('views', path.join(__dirname, 'views'))


//===========Mongoose===========

const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/express_2000');
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB)'))
db.once('open', () => {
    console.log('Connecté à MongoDB');
})

//=========== routes ===========

//route Bienvenue
// app.get('/bienvenue', (req, res) => {
//     res.send('<center><h1>Ici c\'est express 2000!!</h1> <p>Bam!!</p></center>')
// })

//route Bienvenue Pug
app.get(('/bienvenue'), (req, res) => {
    res.render('bienvenue', {title: 'Bienvenue sur express 2000'})
});

//Route JSON d'information
app.get('/info', (req, res) => {
    res.json({
        titre: "json d'information", 
        message: "ceci est une information"
    })
});

//Accès interdit
app.get('/acces-interdit', (req, res) => {
    res.status(403).send("tu veux quoi?!")
});

//Redirection
app.get('/', (req, res) => {
    res.redirect('/bienvenue')
});


//liste liens
const listLiens = path.resolve("public", "list.html")
app.get('/list', (req, res) => {
    res.sendFile(listLiens)
});

//===========Routers===========
const bookRoutes = require('./src/routes/bookRoutes.js');

app.use('/livres', bookRoutes)

// ======================

// Mauvaise route
const tracteur = path.join("images", "tracteur.jpg");
app.get('*', (req, res) => {
    res.send(`<img src="${tracteur}" />`)
});

// Mauvaise route V2
// const mauvaiseRoute = path.resolve("public", "mauvaiseRoute.html")
// app.get('*', (req, res) => {    
//     res.sendFile(mauvaiseRoute)
// })

//On lance le serveur
app.listen(PORT, () => {
    console.log(`serveur en route sur le port: ${PORT}`);
});