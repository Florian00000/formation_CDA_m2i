const { Etudiant } = require("../../config/db");

const etudiantController = {
  create: async (req, res) => {
    try {
      const { firstName, lastName } = req.body;
      const newEtudiant = await Etudiant.create({ firstName, lastName });
      res.status(201).json(newEtudiant);
    } catch (error) {
      res
        .status(500)
        .json({ message: "Erreur lorsde l'ajout de l'étudiant à la BDD" });
    }
  },

  getAll: async (_req, res) => {
    try {
      const etudiants = await Etudiant.findAll();
      res.status(200).json(etudiants);
    } catch (error) {
      res
        .status(500)
        .json({ message: "Erreur lors de la récupération des étudiants" });
    }
  },

  getById: async (req, res) => {
    const etudiantId = req.params.id;
    try {
      const etudiant = await Etudiant.findOne({ where: { id: etudiantId } });
      if (!etudiant) {
        res.status(404).json("L'étudiant demandé n'existe pas");
      } else {
        res.status(200).json(etudiant);
      }
    } catch (error) {
      res
        .status(500)
        .json({ message: "Erreur lors de la récupération des étudiants" });
    }
  },

  updateById: async (req, res) => {
    //On récuppère les informations
    const etudiantId = req.params.id;
    const { firstName, lastName } = req.body;
    try {
      //On update l'étudiant en le trouvant grâce à son Id
      const etudiantUpdated = await Etudiant.update(
        {
          firstName: firstName,
          lastName: lastName,
        },
        { where: { id: etudiantId } }
      );
      if (!etudiantUpdated[0]) {
        res.status(404).json("Le changement n'a pas été effectué");
      } else {          
        res.status(204).json("Changements pris en compte");
      }
    } catch (error) {
        res
        .status(500)
        .json({ message: "Erreur lors de la récupération des étudiants" });
    }
  },

  deleteById: async (req, res) => {
    const etudiantId = req.params.id;
    try {
        const validateDestroy = await Etudiant.destroy({where: {id: etudiantId}})
        if (validateDestroy == 1) {
            res.status(200).json("L'étudiant a été supprimmé avec succès");
        } else {
            res.status(404).json("Etudiant non trouvé");
        }
    } catch (error) {
        res
        .status(500)
        .json({ message: "Erreur lors de la récupération des étudiants" });
    }
  }
};

module.exports = etudiantController;
