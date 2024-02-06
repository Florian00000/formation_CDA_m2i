const { User } = require ("../../config/db");
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const userController = {
    signup: (req, res) => {
        const { username, password, admin } = req.body;

        //on hash le mdp avant de l'envoyer à la BDD
        bcrypt.hash(password, 10, async (err, hash) => {
            if (err) throw err; 
            const newUser = {
                username: username,
                password: hash,
                admin: admin
            }
            try {
                //On enregistre le nouvel utilisateur dans la BDD
                await User.create(newUser)
                res.status(201).json(newUser);
            } catch (error) {
                res.status(500).json({ message: "Erreur lors de l'inscription", error})
            };
        });
    },

    login: async (req, res) => {
        const { username, password} = req.body;

        try {
            //On recherche l'utilisateur dans la BDD
            const user = await User.findOne({ where: {username: username} })

            if (!user) {
                return res.status(401).send("Email ou mot de passe incorrect");
            }else{
                //Si l'utilisateur existe on vérifie le mdp et on renvoi un token jwt
                bcrypt.compare(password, user.password, (err, result) => {
                    if (result) {
                        res.status(200).json({
                            //On crée un jwt avec des infos deans le payload
                            token: jwt.sign({
                                id: user.id,
                                username: user.username
                            }, "RANDOM_TOKEN_SECRET", {
                                expiresIn: "1d"//Le token expire dans 1 jour
                            })
                        })
                    }else{
                        res.status(401).send("Email ou mot de passe incorrect");
                    }
                })
            }

        } catch (error) {
            res.status(500).json({ error: error.message });
        }
    }
        
}

module.exports = userController;