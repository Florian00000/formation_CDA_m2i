const BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

function mapPokemon(data) {
  return {
    nom:
      data.name.substring(0, 1).toUpperCase() +
      data.name.substring(1).toLowerCase(),
    taille: data.height,
    poids: data.weight,
  };
}

document.addEventListener("DOMContentLoaded", async () => {
  const response = await fetch(BASE_URL + "pikachu");
  const pikachuComplet = await response.json();
  const pikachuSimple = mapPokemon(pikachuComplet);
  console.log(pikachuSimple);

  const monPost = {
    userId: 24,
    title: "Title",
    body: "Description",
  };

  const postId = 24;

  const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
    headers: {
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(monPost),
  });
  const data = await res.json();
  console.log(data);

  console.log("------------");
  console.log(monPost);
  console.log("------------");
  console.log(JSON.stringify(monPost));

  const resBis = await fetch(
    "https://jsonplaceholder.typicode.com/posts/" + postId,
    {
      method: "DELETE",
    }
  );
  const dataBis = await resBis.json();
  console.log(dataBis);
});
