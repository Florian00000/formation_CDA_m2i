const Sequelize = require("sequelize");

const sequelize = new Sequelize("bibliotheque", "root", "admin59", {
  host: "localhost",
  dialect: "mysql",
});

// Synchronisation des modèles
const Book = require("../models/Book")(sequelize);
const User = require("../models/User")(sequelize);

sequelize
  .sync({ force: false })
  .then(() => console.log("La base de données à bien été synchronisée"))
  .catch((error) =>
    console.error("Problème lors de la synchronisation :", error.message)
  );

module.exports = {
  sequelize,
  Book,
  User,
};
