const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const User = sequelize.define("User", {
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        username: {
            type: DataTypes.STRING(50),
            allowNull: false,
            validate: {
                len: {
                    args: [1,50],
                    msg: "Le Nom doit contenir maximum 50 caractères"
                }
            }
        },
        password: {
            type: DataTypes.STRING,
            allowNull: false
        },
        admin: {
            type: DataTypes.BOOLEAN,
            allowNull: false,
            defaultValue: false
        }
    });

    return User;
};