const Sequelize = require('sequelize');

const sequelize = new Sequelize(process.env.DB_DATABASE, process.env.DB_USER, process.env.DB_PASSWORD, {
    host: process.env.DB_HOST,
    dialect: "mysql"
});

//Synchronisation des modèles
const User = require("../src/models/User")(sequelize);
const Etudiant = require('../src/models/Etudiant')(sequelize);

sequelize
    .sync({ force: false })//Ne supprime pas le la BDD à chaque actualisation, en en créant une nouvelle
    .then(() => console.log("La BDD a bien été synchronisée"))
    .catch((error) => console.error("Problème lors de la synchronisation", error.message));

module.exports = {
    sequelize,
    User, 
    Etudiant
};