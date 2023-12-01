const BASE_URL = "https://pokeapi.co/api/v2/";

//=========================Fonctions=========================

//Fonction pour créer un objet pokemon
async function mapPokemon(data) {
    return {
        id: data.id,
        name: data.name,
        height: data.height,
        weight: data.weight,
        types: data.types,
        abilities: data.abilities,
        picture: data.sprites.other['dream_world'].front_default
    };
}

// Fonction pour récupérer le JSON d'un Pokémon
async function getPokemonByName(nom) {
    try {
        const reponse = await fetch(BASE_URL + "pokemon/" + nom);
        const data = await reponse.json();// On transforme les données reçues en un élément exploitable par notre code
        return data;
    } catch (error) {
        console.error(error)
    }
}

//Fonction pour placer les élément dans le Dom
const domPokemon = function (pokemon) {

    const imgPokemon = document.getElementById("img-pokemon");
    imgPokemon.src = pokemon.picture;

    const nomPokemon = document.getElementById("nom-pokemon");
    nomPokemon.textContent = pokemon.name;

    const taillePokemon = document.getElementById("taille-pokemon");
    taillePokemon.textContent = pokemon.height;

    const poidPokemon = document.getElementById("poid-pokemon");
    poidPokemon.textContent = pokemon.weight;

    const typesPokemon = document.getElementById("types-pokemon");
    const tableauTypes = pokemon.types;
    let objetTypes;
    let retourTypes = "";
    for (let index = 0; index < tableauTypes.length; index++) {
        objetTypes = tableauTypes[index]        
        retourTypes+= `${objetTypes.type.name} `;
    }
    typesPokemon.textContent = retourTypes;

    const capacitesPokemon = document.getElementById("p-capacites");
    let retourCapacites = "";
    for (let index = 0; index < pokemon.abilities.length; index++) {
        retourCapacites+= `${pokemon.abilities[index].ability.name}<br><br>`
        
    }     
    capacitesPokemon.innerHTML = retourCapacites;
}


//=========================Après chargement du DOM=========================

document.addEventListener("DOMContentLoaded", async () => {
    let idPokemon = 250;
    let getPokemon = await getPokemonByName(idPokemon);
    let pokemon = await mapPokemon(getPokemon);
    console.log(pokemon);
    
    
    //On place les éléments dans le dom   
    domPokemon(pokemon); //La fonction n'a pas besoin d'etre await car Le chargement du DOM est async, la fonction va donc attendre que les fonctions await avant elle soit résolue (comme la demande à l'API) pour s'exécuter
    
    
    //Fonction pour les boutons latéraux
    document.getElementById("defilement-droite").addEventListener("click", async (event)=> {
        event.preventDefault();
        idPokemon++
        getPokemon = await getPokemonByName(idPokemon);
        pokemon = await mapPokemon(getPokemon);
        console.log(pokemon);
        domPokemon(pokemon);
    })

    document.getElementById("defilement-gauche").addEventListener("click", async (event)=> {
        event.preventDefault();
        idPokemon--
        getPokemon = await getPokemonByName(idPokemon);
        pokemon = await mapPokemon(getPokemon);
        console.log(pokemon);
        domPokemon(pokemon);
    })
})