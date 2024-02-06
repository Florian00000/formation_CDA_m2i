const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const Etudiant = sequelize.define("Etudiant", {
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true,
        },
        firstName: {
            type: DataTypes.STRING(50),
            allowNull: false,
            validate: {
                len: {
                    args: [1,50],
                    msg: "Le Prénom doit contenir maximum 50 caractères"
                }
            }
        },
        lastName: {
            type: DataTypes.STRING(50),
            allowNull: false,
            validate: {
                len: {
                    args: [1,50],
                    msg: "Le Nom doit contenir maximum 50 caractères"
                }
            }
        }
    });

    return Etudiant;
}