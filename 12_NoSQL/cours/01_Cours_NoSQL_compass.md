# Le NoSQL

Le terme "NoSQL" (Not Only SQL) fait référence à une  lcasse de système de gestion de BDD qui diffèreent de BBD relationnelles traditionnelles.  
Les BDD NoSQl  sont conçus pour répondre à des besoins spécifiques, tels que la gestion de grandes quantités de données non structurées ou semi-structurées, la mise à l'échelle horizontale facile, la flexibilité de schéma, et une meilleureperformance dans certains scénarios.

Les caractéristiques  générales des BDD NoSQL incluent: 

- **Schhéma flexible:** Elles permettent de stocker des données sans avoir à définir un schéma fice à l'avence. Cela offre une flexivbilité accrue pour traiter particulièrement les données évolutives ou diverses. 

- **Evolutivité horizontale:** Elles sont concues pour évoluer facilement en ajoutant de nouveaux serveurs au lieu d'augmenter les ressources d'un serveur existant. Cela facilite la gestion de volumes de données massives.

- **Gestion de données non structurées ou semi-structurées** Les BDD NoSQL peuvent gérer des types de données variés, tel que les document, des paires clé-valeurs, des graphiques ou colonnes offrant une flexivbilité accrue par rapport au BDDr qui sont basées sur un modèle tabulaire.

- **Haute performance dans des cas spécifiques**: Les BDDR peuvent offir des performances supérieurs à celles des BDDR, en particulier lorsqu'il s'agit de lecture ou d'écritures parallèle.

## SQL ou NoSQL ?

Voici quelques critères à considérer lors du choix entre SQL et NoSQL: 

- **Sructure de données:** Utiliser SQL si vos donnéées sont principalement tabulaires et interconnectées avec des relations complexes. Optez pour du NoSQL si vous avez plutôt besoin d'un schéma flexible.

- **Schémas:** SQL à un schéma fixe où la structure doit être définie à l'avance. Les modification de schéma d'ampleur peuvent être difficiles. En NoSQL, vous pouvez ajouter de nouveaux champs sans avoir à définir un schéma rigide à l'avance.

- **Transactions ACID**: Si la cohérence des données et la garantie des transactions sont cruciales pour votre application, SQL peut êter le choix appropré. Le NoSQL, en particulier sous la forme de clé-valeur, va sacrifier les propriétés ACID pour améliorer la performance et l'évolutivité.

- **COmplexité des requêtes**: SQL excelle dans les requêtes complexes qui impliquent des relations entre de nombreuses tables. Le NoSQL va être plus approprié pour des requêtes courtes et simple sur des ensembles de données massifs.

Exemples d'utilisation: SQL est souvent utilisé dans des applications où la structure des données est stable et bien définie comme les applications bancaires/financières, les système de gestion de stock...  
NoSQL est couramment utilisé daans des applications nécessitant cette fameuse mise à l'échelle horizontal, telles que les réseaux sociaux, les application de suivi en temps réel, les applications de Big Data etc...

## Introducction à MongoDB

MongoDB est une BDD NoSQL populaire, orientée document, conçue pour stocker, interroger et gérer des données de manière flexible et scalable.

- **Modèle de données:** MongoDB stocke lesdonnées sous forme de documents au format BSON (Binary JSON), très similaire au JSON. Chaque document  peut contenir des champs de différents types,  et la structure des documents peut varier d'un enregistrement à l'autre.

- **Collection et Documents:** Les documents MongoDB sont regroupés dans des collections, qui sont équivalents à des tables dans le monde des bases de données relationnelles. Cependant, contrairement aux tables SQL, les collections ne nécessitent pas un schéma fixe.

- **Langage de requête:** MongoDB utilise un langage de requête appelé MongoDB Query Language (MQL) pour intéragire avec BDD. Les opérations de lecture, écriture, mise à jour et suppression sont effectuées à l'aide de commandes MongoDB.

- **Indexation:** MongoDB prend en charge l'indexation de données, ce qui permet d'accélérer les opérations de reccherches en créant des index sur des champs fréquemment utilisés. Cela contribue à améliorer les perfommances de requêtes.

- **Evolutivitée:** MongoDB est spécifiquement conçue pour l'évolutivitée horizontale, ce qui signifie qu'il est facile d'ajouter de nouveaux serveurs pour gérer des charges de travail croissantes. Cela le rend adapté aux applications nécessitant une mise à l'échelle dynamique.

## JSON ou  BSON?

JSON est un format de sérialisation de données en texte lisible par l'homme. BSON est sa version binaire étendue, spécialement conçue pour MongoDB; offrant une efficacité de stockahe accrue avec des types de données supplémentaires. MongoDB utilise BSON comme stockage de format natif.

EN raison de sa réprésentation binaire, BSON est plus compact et offrant une meilleur efficacité en terme de stockage de traitement.

## Collections et Document

1. **Structure:**
    - **Document:** Un document MongoDB est une unitée de stockage de données au format BSON. Il est similaire à un objet JSON et peut contenir des paires clée-valeur, des tableaux ainsi que d'autre documents imbriqués.

    - **Collection:** Une collection MongoDB est un ensemble de documents. Contrairement à une table, elle n'a pas de schéma fixe, chaque document peut avoir une structure différente. 

2. **Propriétés:** 
    - **Identifiant unique (_id):** Chaque document à un champ spécial appelé "_id" qui doit être unique au sein de la collection. Il peut être généré automatiquement ou spécifié manuellement.
    
    - **Collections sans schéma fixe:** Les collections ne nécessitent pas de déclaration de schéma à l'avance.

## Opération CRUD dans MongoDB Compass:

- **Insertion (create):** Sélectionnez la base de données et la collection. Cliquez sur le bouton Add >> Insert Document et saisissez les valeurs du nouveau document.

- **Lecture (read):** Sélectionnez la collection dans Compass. Utilisez l'interface graphique pour construire des requêtes de recherche avec des filtres.

- **Mise à jour (update):** Au sein de la collection, utilisez le bouton "Edit" à droite de chaque document.

- **Suppression (Delete):** Utilisez le bouton "Delete" pour supprimer pun ou plusieurs documents.

## Les filtres

Les filtres dans MongoDB sont utilisés pour spécifier les critères de recherche lors des opérations de lecture et des opérations de suppression et de mise à jour. Les filtres permettent des restreindre les résultats en fonction de conditions spécifiques.

**1. Opérateurs de comparaison:**  
- Les opérateurs de comparaison, tels que `$eq` (égal), `$ne` (différent), `$gt` (supéreur à), `$lt` (inférieur à), `$gte` (supérieur ou égale à),  `$lte` (inférieur ou égale à) sont utilisés pour comparer des valeurs. 

**2. Opérateurs logiques:**
- Les opérateurs logiques, tels que `$and`, `$or`, `$not` sont utilisés pour combiner des conditions

**3. Opérateurs d'éléments:**
- Les opérateurs d'éléments, tels que `$exists` et `$type`, permettent de filtrer les documents en fonction de la présence ou du type d'un champ.

**4. Opérateurs d'éléments dans un tableau:**
- Les opérateurs tels que `$in`, `$min`, `$all`, sont utilisés pour effectuer des requêtes dans des tableaux.

```javascript
// Exemple récupérer les utilisateurs dont l'âge est soit 25, soit 30
{"age": {$in: [25,30]}}

// Exemple récupérer les utilisateurs dont l'âge n'est pas 25 ou 30
{"age": {$nin: [25,30]}}
```

**5. Opérateurs de recherche de texte:** 
- L'opérateur `$text` est utiliseé pour effectuer des recherches de texte dnas les champs textuels indexés.

**6. Opérateurs d'expressions régulières:**
- L'opérateur `$regex` permet d'appliquer des expréssions régulières dans les filtres.

```javascript
//Récupérer les utilisateurs dont le nom commence par la lettre "L"
{"nom": {$regex: /^L/}}
```
