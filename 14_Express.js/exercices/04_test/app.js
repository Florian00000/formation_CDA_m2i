const express = require('express');

const app = express();
const PORT = process.env.PORT || 3000;

//On utilise la méthode listen de l'application 
app.listen(PORT, () => {
    console.log(`Baby foot dans 30 minutes mais en attendant on est sur le port ${PORT}` );
}) 


app.get('/', (req, res) => {
    res.send("Plus que 15 minutes")
});

app.get("/baby", (req, res) => {
    res.send("Le baby approche")
})