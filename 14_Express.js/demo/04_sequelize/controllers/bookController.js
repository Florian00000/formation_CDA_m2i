const { Book } = require("../config/db");

exports.getAllBooks = async (req, res) => {
  try {
    const books = await Book.findAll();
    res.json(books);
  } catch (error) {
    res
      .status(500)
      .json({ message: "Erreur lors de la récupération des livres" });
  }
};

exports.createBook = async (req, res) => {
  try {
    const { titre, auteur } = req.body;
    const newBook = await Book.create({ titre, auteur });
    res.status(201).json(newBook);
  } catch (error) {
    res.status(500).json({ message: "Erreur lors de l'ajout du livre" });
  }
};
