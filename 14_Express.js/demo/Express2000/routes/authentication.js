const express = require("express");
const router = express.Router();
const bcrypt = require("bcrypt");
const fs = require("fs/promises");
const path = require("path");
const jwt = require("jsonwebtoken");

const dataUser = path.join(__dirname, "../data/user.json");

async function fileContent() {
  try {
    const data = await fs.readFile(dataUser, "utf8");
    return JSON.parse(data);
  } catch (error) {
    throw error;
  }
}

router.post("/inscription", async (req, res) => {
  const { email, password } = req.body;
  const users = await fileContent();

  bcrypt.hash(password, 10, (err, hash) => {
    if (err) throw err;
    const newUser = {
      id: users.length + 1,
      email: email,
      password: hash,
    };
    users.push(newUser);
    fs.writeFile(dataUser, JSON.stringify(users), (err, result) => {
      if (result) {
        res.send("Utilisateur ajouté avec succès");
      } else {
        console.error("Erreur lors de l'ajout d'un utilisateur");
        return;
      }
    });
  });
});

router.post("/connexion", async (req, res) => {
  const { email, password } = req.body;
  const users = await fileContent();
  const user = users.find((user) => user.email == email);

  if (user) {
    bcrypt.compare(password, user.password, (err, result) => {
      if (result) {
        res.status(200).json({
          token: jwt.sign({ user: user.id }, "RANDOM_TOKEN_SECRET", {
            expiresIn: "1d",
          }),
        });
      } else {
        res.status(401).send("Email ou mot de passe incorrect");
      }
    });
  } else {
    res.status(401).send("Email ou mot de passe incorrect");
  }
});

module.exports = router;
