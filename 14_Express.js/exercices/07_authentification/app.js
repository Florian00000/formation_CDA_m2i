const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;
const userRoutes = require('./src/routes/userRoutes');

//mongoose
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/exerciceAuthentification');
const db = mongoose.connection;

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB'));
db.once('open', () => {
    console.log('Connecté à MongoDB');
})

app
    .use(express.json())
    .use("/api", userRoutes);




//On lance le serveur
app.listen(PORT, () => {
    console.log(`serveur en route sur le port ${PORT}`);
})