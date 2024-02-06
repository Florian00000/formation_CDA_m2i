# Opérations CRUD ave sequelize

Avec sequelize vous pouvez effectuer des opérations CRUD (create, read, update, delete) sur vos modèles de manière facile et intuitive.

Création d'un Enregistrement :

```javascript
const newUser = await User.create({
  username: 'Toto',
  password: "toto123"
})
```

Lecture des enregistrements :

```javascript
const allUsers = await User.findAll()
```

Mise à jour d'un enregistrement :

```javascript
await User.update({username : 'Titi'}, {where: {username: "Toto"}})
```

Suppression d'un enregistrement : 

```javascript
await User.destroy({where: {username: "Toto"}})
```