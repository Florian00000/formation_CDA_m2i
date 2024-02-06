# Utilisation de Sequelize ORM dans node.js

Sequelize est ORM (Object-Relational Mapping) populaire pour Node.js qui facilite l'interaction avec les bases de données, telles que MySQL, PostgreSQL, SQLLite. Il permet de manipuler les données de la base de données en utilisant des objets JavaScript plutôt que des requêtes SQL, ce qui rend le développement d'application plus fluide et plus rapide.

## configuration de Sequelize

Avant d'utiliser Sequelize dans votre application Node.js, vous devez d'abord l'installer et le configurer :

```bash
npm install sequelize
```

Installez également le pilote de base de données correspondant à celle que vous utilisez :

```bash
npm install mysql2
```

- Configuration de Sequelize : Configurez sequelize dans votre application en définiissant les paramètres de connexion à la base de données. Créez un fichier de configuration (par exemple db.js)

```javascript
const sequelize = new Sequelize(
  "database_name",
  "username",
  "password",
  {
    host: "localhost",
    dialect: "mysql"
  }
)
```

# Définition de modèles avec sequelize

Les modèles Sequelize représentent les tables de la base de données sous forme d'objets Javascript. Chaque modèle correspond à une table et chaque instance du modèle représente une ligne de la table.

```javascript
// user.js
const { DataTypes } = require("sequelize")

module.exports = (sequelize) => {
  const User = sequelize.define('User', {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true
    },
    username : {
      type : DataTypes.STRING,
      allowNull: false,
      unique: true
    },
    password: {
      type: DataTypes.STRING,
      allowNull: false
    }
  })

  return User
}

```

## Synchronisation des modèles avec la base de données

Une fois que vous avez défini vos modèles, vous devez synchroniser votre application avec la base de données pour créer les tables correspondantes. Vous pouvez le faire en utilisant la méthode sync() de sequelize.

```javascript
// config/db.js
// Synchronisation des modèles
const Book = require("../models/Book")(sequelize);
const User = require("../models/User")(sequelize);

sequelize
  .sync({ force: false })
  .then(() => console.log("La base de données à bien été synchronisée"))
  .catch((error) =>
    console.error("Problème lors de la synchronisation :", error.message)
  );
```