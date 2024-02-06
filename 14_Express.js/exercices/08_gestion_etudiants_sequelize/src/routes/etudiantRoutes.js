const express = require("express");
const etudiantController = require('../controllers/etudiantController');

const router = express.Router();


router.post("/create", etudiantController.create);
router.get("/getAll", etudiantController.getAll);
router.get("/getById/:id", etudiantController.getById);
router.put("/updateById/:id", etudiantController.updateById);
router.delete("/deleteById/:id", etudiantController.deleteById);

module.exports = router;