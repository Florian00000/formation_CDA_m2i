const User = require('../models/user');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const userController = {
    signup: (req, res) => {        
        const { email, password } = req.body;

        //on hash le mdp avant de créer l'objet à envoyer dans la bdd
        bcrypt.hash(password, 10, async (err, hash) => {
            if (err) throw err;
            const newUser = new User({
                email: email,
                password: hash
            });
            try {
                //On enregistre l'utilisateur
                await newUser.save();
                res.status(201).json(newUser);
            } catch (error) {
                res.status(400).json({ error: error.message});
            }
        })        
    },

    login: async (req, res) => {
        const { email, password } = req.body;

        try {
            //On recherche l'utilisateur dans la bdd
            const user = await User.findOne({ email: email})
            if (!user) {
                return res.status(401).send("Email ou mot de passe incorrect");
            }else{
                //Si l'utilisateur existe, on vérifie le mdp et on renvoie un token jwt avec en info l'id de l'utilisateur
                bcrypt.compare(password, user.password, (_err, result) => {
                    if (result) {
                        res.status(200).json({
                            //On crée un jwt avec dans le payload l'id de l'utilisateur
                            token: jwt.sign({ user: user.id }, "RANDOM_TOKEN_SECRET", {
                                expiresIn: "1d", //Le token expire dans 1 jour
                            })
                        })
                    } else {
                        res.status(401).send("Email ou mot de passe incorrect");
                    }
                })
            }


        } catch (error) {
            res.status(500).json({ error: error.message });
        }

    },

    profile: async (req, res) => {
        const userId = req.body.payload.user;

        //autre version
        // const userId = req.auth.userId;

        //On renvoie un json avec l'id de l'utilisateur si celui ci à bien un token valide (grâce au middleware d'authentification)
        res.status(200).json(userId);
    }
}

module.exports = userController;