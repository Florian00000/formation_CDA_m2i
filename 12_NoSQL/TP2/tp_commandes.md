1. Créer un élément
Ajouter l'utilisateur dans la collection users:
- Chuck Norris
- 77 ans
- hobbies : ["Karate", "Kung-fu", "Ruling the world"]


```javascript
db.users.insertOne({"name": "Chuck Norris", "age": 77, "hobbies": ["Karate", "Kung-fu", "Ruling the world"]})
```

2. Lecture d'un élément
- Afficher Chuck Norris (si il le permet).

```javascript
db.users.findOne({"name": "Chuck Norris"})
```

- Afficher Chuck sans le champs _id.

```javascript
db.users.findOne({"name": "Chuck Norris"}, {_id:0})
```

- Afficher les utilisateurs qui ont entre 20 et 25 ans.

```javascript
db.users.find({$and: [{"age": {$gte: 20}}, {"age": {$lte: 25}}]})
```

- Afficher uniquement les hommes entre 30 et 40 ans.

```javascript
db.users.find({$and: [{"gender": "male"}, {$and: [{"age": {$gte: 30}}, {"age": {$lte: 40}}]}]})
```

- Afficher les utilisateurs habitant l'état de Louisianne (Louisiana)

```javascript
db.users.find({"address.state": "Louisiana"})
```

- Afficher les 20 premiers utilisateurs triés par ordre décroissant d'age.

```javascript
db.users.find().sort({age: -1}).limit(20)
```

- Combien y'a-t-il de femmes agées de 30 ans?

```javascript
db.users.find({$and: [{"age": 30}, {"gender": "female"}]}).count()
```

3. Modifier/Supprimer un élément
- Nos juristes nous ont dit que nous ne pouvions plus garder les numéro de
téléphones de nos utilisateurs : supprimer le champ phone de tous les
enregistrements.

```javascript
db.users.updateMany({}, {$unset: {"phone": ""}})
```

autre version:
```javascript
db.users.updateMany({}, {$unset: {"phone": ""}}, {$multi: 1})
```

- Chuck Norris est venu nous dire que le temps ne marquait pas Chuck Norris,
mais que Chuck Norris marquait le temps : changer l'age de Chuck Norris à
infinity

```javascript
db.users.updateOne({"name": "Chuck Norris"}, {$set: {"age": "infinity"}})
```

- Ajoutons un hobby à tous nos utilisateurs de plus de 50 ans : jardinage

```javascript
db.users.updateMany({"age": {$gt: 50}}, {$push: {"hobbies": "jardinage"}})
```

