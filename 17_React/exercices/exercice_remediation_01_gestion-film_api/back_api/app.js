const express = require("express");
const cors = require('cors');
const mongoose = require("mongoose");
const movieRoutes = require("./routes/movieRoutes");

const app = express();
const port = 3000;

mongoose.connect("mongodb://localhost:27017/express_film_bibliotheque", {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

const db = mongoose.connection;

db.on("error", console.error.bind(console, "Erreur de connexion à mongoDB"));
db.once("open", () => {
  console.log("Connecté à mongoDB");
});

app.use(cors());

app.use(express.json()).use("/api/movies", movieRoutes);

app.get("*", (req, res) => {
  res.send("Cette route n'existe pas");
});

app.listen(port, () => {
  console.log(`http://localhost:${port}`);
});