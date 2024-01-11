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

