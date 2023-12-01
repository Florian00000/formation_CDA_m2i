// On stocke l'URL commun à nos futures requêtes dans une constante pour éviter d'avoir à la réécrire à chaque fois et éviter les erreurs typographiques
const BASE_URL = "https://pokeapi.co/api/v2/";

// On peut créer une fonction pour 'découper / transformer' un objet complexe en un objet plus simple que l'on veut traiter (on appelle ça faire du mapping)
function mapPokemon(data) {
  return {
    height: data.height,
    weight: data.weight,
    name: data.name,
  };
}

// La plupart des mécanisme de récupération de données se trouveront dans des fonction asynchrone de sorte à pouvoir attendre les différents traitements dont le temps n'est pas dépendant de notre programme
async function getPokemonByName(name) {
  const response = await fetch(BASE_URL + "pokemon/" + name); // On récupère des données sur un serveur distant via une API
  const data = await response.json(); // ON transforme les données reçues en un élément exploitable par notre code
  return data; // On retourne l'élément reçu après tous les traitements
}

async function createNewPost(post) {
  const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
    // Pour envoyer des informations, on va devoir faire un POST

    // Il va falloir défini le contenu de notre envoi comme étant du JSON
    headers: {
      "Content-Type": "application/json",
      // 'Authorization': 'Bearer votreToken'
    },

    // ON va devoir informer l'API que l'on veut lui envoyer des choses
    method: "POST",

    // ON doit transformer nos données en un flux de texte afin que l'API puisse de son côté le traiter (un objet Javascript n'est pas compréhensible directement, il faut le sérialiser en JSON, qui est au final un texte)
    body: JSON.stringify(post),
  });
  const data = await response.json();
  return data;
}

async function deletePostById(postId) {
  const response = await fetch(
    "https://jsonplaceholder.typicode.com/posts/" + postId,
    {
      method: "DELETE", // Ici, on informe le serveur que l'on veut supprimer quelque chose
    }
  );
  if (response.status === 200) return true;
  else throw new Error("Suppression impossible..."); // Si le serveur ne permet pas la suppression, il va nous retourner un code status différent de 200 - Tout s'est bien passé
}

// Pour que l'ensemble de notre code puisse gérer l'asynchrone, la fonction passée en second paramètre de notre eventListener sera elle même porteuse du mot-clé 'async'
document.addEventListener("DOMContentLoaded", async () => {
  // const response = await fetch(BASE_URL + "pokemon/ditto");
  // const dataDitto = await response.json();
  // const responseB = await fetch(BASE_URL + "pokemon/growlithe");
  // const dataGrowlithe = await responseB.json();
  const ditto = await getPokemonByName("ditto"); // Pour attendre, il faut utiliser le mot-clé 'await'
  const growlithe = await getPokemonByName("growlithe");

  // Pour transformer les données complexe en des données plus simple, on les fait passer dans notre fonction de mapping via .map()
  // const datas = [dataDitto, dataGrowlithe].map((data) => mapPokemon(data));
  const datas = [ditto, growlithe].map(mapPokemon);
  console.log(datas);
  // const objFinal = mapPokemon(data);
  // console.log(objFinal);

  const postCree = await createNewPost({
    userId: 22,
    title: "Title",
    body: "Description",
  });
  console.log(postCree);

  try {
    await deletePostById("sdqsdqdqs");
  } catch (e) {
    console.error(e);
  }
});

/*
  Version du 30/12/2023
*/
// document.addEventListener("DOMContentLoaded", async () => {
//   const maPromesse = () =>
//     new Promise((resolve, reject) => {
//       // Début du code de la promesse

//       // Pour marquer la fin de la promesse, on va provoquer la fonction resolve
//       setTimeout(() => {
//         if (Math.random() >= 0.5) {
//           resolve({
//             propA: "Titi",
//             propB: 123,
//           });
//         } else {
//           reject("Echec");
//         }
//       }, 2000);
//     });

//   let maVariable;

//   /* Notation pré-ES7 */
//   // maPromesse()
//   //   .then((varTest) => {
//   //     maVariable = varTest.propA;
//   //     return maPromesse();
//   //   })
//   //   .then((value) => console.log(value))
//   //   .catch((err) => console.warn(err));

//   try {
//     const varTest = await maPromesse();
//     await maPromesse();
//     maVariable = varTest.propA;
//     document.querySelector("#result").textContent = maVariable;
//   } catch (err) {
//     console.warn(err);
//   }

//   async function getElements(url, postId) {
//     const response = await fetch(url + postId);
//     if (response.status === 200) {
//       const data = await response.json();
//       return data;
//     } else {
//       throw new Error("Not good");
//     }
//   }

//   const url = "https://jsonplaceholder.typicode.com/posts/";

//   try {
//     console.log(await getElements(url, 5));
//   } catch (e) {
//     console.error(e);
//   }

//   try {
//     const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
//       headers: {
//         "Content-Type": "application/json",
//       },
//       method: "POST",
//       body: JSON.stringify({
//         userId: 1,
//         title: "Title",
//         body: "Body",
//       }),
//     });
//     const data = await response.json();
//     console.log(data);
//   } catch (e) {
//     console.error(e);
//   }
// });
