const jwt = require('jsonwebtoken');

function isAuthenticated(req, res, next) {
    try {
        const token = req.headers.authorization.split(" ")[1];
        //On met l'id de l'utilisateur dans la requête
        req.body.payload = jwt.verify(token, "RANDOM_TOKEN_SECRET");

        //autre version
        // const decodedToken = jwt.verify(token, "RANDOM_TOKEN_SECRET");
        // const userId = decodedToken.user;
        //req.auth = {
        //     userId: userId 
        // }

        

        return next();
    } catch (error) {        
        res.status(401).json({ message: "Merci de vous connecter" });
    }
}

module.exports = isAuthenticated;