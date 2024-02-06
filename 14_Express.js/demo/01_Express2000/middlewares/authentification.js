const jwt = require("jsonwebtoken");

function isAuthenticated(req, res, next) {
  try {
    // Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoxLCJpYXQiOjE3MDcxMzk2NzIsImV4cCI6MTcwNzIyNjA3Mn0.6R_w_4QVGje4emYrhZSaEEGzQJCuKFkkyn23DAO7bFU
    const token = req.headers.authorization.split(" ")[1];
    const decodedToken = jwt.verify(token, "RANDOM_TOKEN_SECRET");
    const userId = decodedToken.userId;

    return next();
  } catch (error) {
    // L'utilisateur n'est pas authentifié :
    res.status(401).json({ message: "Merci de vous connecter" });
  }
}

module.exports = isAuthenticated;
