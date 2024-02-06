const express = require("express");
const bookController = require("../controllers/bookController");

const router = express.Router();

router.get("/", bookController.getAllBooks);
router.post("/add-book", bookController.createBook);

module.exports = router;
