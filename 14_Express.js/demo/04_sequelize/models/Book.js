const { DataTypes } = require("sequelize");

module.exports = (sequelize) => {
  const Book = sequelize.define("Book", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    titre: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        len: {
          args: [1, 25],
          msg: "Le titre doit contenir maximum 25 caractères",
        },
      },
    },
    auteur: {
      type: DataTypes.STRING,
      allowNull: false,
    },
  });

  return Book;
};
