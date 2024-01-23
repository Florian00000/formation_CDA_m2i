# Gestion des modules en Node.js

## Compréhension du système de module intégré

Node.js, en tant qu'environnement JavaScript côté serveur, dispose d'un système de modules intégré qui permet d'organiser le code de manière modulaire. Cela favorise la réutilisation du code, la gestion des dépendances et la maintenabilité des applications.

### 1. Qu'est ce qu'un module ?

En JS, un module est essentiellement un fichier contenant du code. Ce code peut être des variables, des fonctions ou des objets, et il peut être réutilisé dans d'autres parties de l'application.

### 2. Le système de modules de Node.js

Node.js utilise un système de modules basé sur le système de fichiers local. Chaque fichier JS est considéré comme un module, et les fonctionnalitées exposées par un module peuvent être importées dans d'autres modules.

### 3. require() et module.exports

- **`require()`**: Cette fonction est utilisée pour importer des fonctionnalitées d'autres modules dans le module en cours. Elle prend en paramètre le chemin du module à importer. Par exemple:

```js
const myModule = require('./myModule');
```

- **`module.exports`**: Cette propriété est utilisée pour exporter des fonctionnalités depuis un module, les rendant ainsi accessibles pour d'autre modules. Par exemple:

```js
// Dans myModule.js
const myFunction = () => {
  // Fonctionnalités à exporter
}

module.exports = myFunction;
```

```js
//config.js
const apiKey = "your-api-key";
const apiUrl = "https://api.example.com"

module.exports = {
  apiKey,
  apiUrl
};
```

## 4. Nouvelle syntaxe

En Node.js, l'utilisation de la syntaxe d'import/export se fait aussi très souvent avec ECMAScript (ES) Modules depuis la version 13.2.0. Voici comment se construit cette nouvelle syntaxe:

**Exportation d'un module:**

```js
//myModule.js
export const myVariable = "Hello World !";

export function myFunction() {
  console.log("This is a function.");
}
```

**Importation dans un autre module:**

```js
//autreModule.js
import {myVariable, myFunction} from './myModule'

console.log(myVariable);
myFunction();
```

**Attention:** Assurez-vous de configurer votre projet pour autoriser l'utilisation des modules ES en ajoutant `"type": "module"` à votre fichier `package.json`.

```json
// package.json
{
  "type": "module",
  "scripts": {
    "start": "node mon_fichier.js"
  }
}
```

## 5. CommonJS vs ESModules ?

Les différences entre CommonJS et ES Modules résident principalement dans la syntaxe d'importation/exportation. Mais cela implique plusieurs distinctions:

1. **Charge dynamique vs charge statique:**

- **CommonJS**: Les importations sont résolues de manière dynamique à l'exécution

- **ES Modules**: Les importations sont résolues statiquement au moment de l'analyse du code. Cela permet aux outils de développement de détecter les dépendances à l'avance.

2. **Support natif dans le navigateur**

- **CommonJS**: Conçu pour être utilisé côté serveur. N'est pas nativement pris en charge dans les navigateurs.

- **ES Modules**: Conçu pour être utilisé côté serveur et côté client. Est pris en charge nativement dans les navigateurs modernes.

3. **Importations conditionnelles**

- **CommonJS**: Les importations conditionnelles peuvent être gérées avec des constructions conditionnelles classiques.

- **ES Modules**: Les importations conditionnelles nécessitent des approches différentes, car les importations sont résolues statiquement.

En résumé, bien que les deux systèmes aient pour objectif de permettre la modularité dans JavaScript, les détails de leur mise en oeuvre et de leur utilisation diffèrent. CommonJS est historiquement utilisé côté serveur avec Node.js, tandis que les modules ES visent à standardiser la syntaxe d'import/export et sont prises en charge aussi bien côté serveur que côté client dans les navigateurs modernes.