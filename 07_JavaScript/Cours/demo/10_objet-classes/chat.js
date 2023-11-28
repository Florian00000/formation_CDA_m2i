export default class Chat {
  // Pour créer des attributs privés, on va utiliser la notation '#nomAttribut'
  // Via des attributs privés, des getters et des setters on peut réaliser un mécanisme qui se nomme l'encapsulation de nos données (de sorte à en contrôler l'accès)
  #name;
  #age;

  constructor(name, age) {
    this.#name = name;
    this.#age = age;
  }

  // Pour créer une méthode privée (accessible uniquement dans le code de la classe), pareil, on peut utiliser la notation '#nomMethode(params) { ... }'
  #meow() {
    console.log("Meow!");
  }

  methodName() {
    // Code de methodName()...

    // Ici, on a donc accès aux méthodes privées
    this.#meow()

    // Et aux champs privés
    return this.#age
  }

  // Pour pouvoir rendre possible la récupération des champs privés d'une classe, on va passer par un getter, donc la syntaxe est la suivante
  get name() {
    return this.#name
  }
  
  // Pour pouvoir rendre possible la modification des champs privés d'une classe, on va passer par un setter, donc la syntaxe est la suivante
  set name(value) {
    // Vu qu''il s'agit d'une fonction, il est possible d'y mettre du code. Ce code peut être synchrone ou non via un getter / setter 'async'
    if (typeof value !== 'number') {
      this.#name = value;
    } else {
      console.error("Pas de nombres pour un nom de chat!");
    }
  }
}

const unChat = new Chat('Caramel', 2)

// On SET l'age du chat (rendu impossible par l'encapsulation)
unChat.#age = 7;

// On GET le nom du chat pour en visualiser ou exploiter la valeur (rendu impossible par l'encapsulation)
console.log(unChat.#name);

unChat.#age = unChat.#name;

unChat.#meow()

console.log(unChat.name);

unChat.name = "Berlioz";
unChat.name = 123;
