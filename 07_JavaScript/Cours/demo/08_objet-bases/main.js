/*
  Pour récupérer des éléments dans la page HTML, on peut utiliser plusieurs méthodes disponibles dans l'objet 'document':
  * getElementById()
  * getElementsByClassName()
  * getElementsByName()
  * 
  * querySelector()
  * querySelectorAll()
*/

document.addEventListener("DOMContentLoaded", () => {
  console.log("Une fois le DOM chargé");

  // On récupère l'élément qui nous intéresse...
  const monElement = document.getElementById("blabla");

  // On peut modifier le texte d'un élément HTML (ce qui se trouve entre les balises ouvrantes et fermantes)
  // monElement.textContent = "Nouveau <b>contenu</b>"

  // Si l'on voulait ajouter de l'HTML, il faut demander l'évaluation de ces balises au navigateur...
  monElement.innerHTML = "Nouveau <b>contenu</b>";

  /*
    Pour déclencher des fonction au clic de l'utilisateur sur un bouton, on peut ajouter l'attribut 'onclick' sur un bouton et y mettre en valeur l'éxecution d'une fonction telle que:
  */
  const logSmth = () => {
    console.log("Something...");
  };

  /*
    Pour utiliser le principe de l'écouteur d'évènement 'click' sur un élément du DOM récupéré via les méthodes vues précédemment tel que:
  */
  monElement.addEventListener("click", () => {
    console.log("Click sur paragraphe");
  });

  const monButton = document.querySelector("button#btn-log");

  monButton.addEventListener("click", (event) => {
    // Autre code...
    console.log(event);
    const monUL = document.querySelector("ul#mon-ul");
    if (monUL) {
      // monUL.innerHTML += "<li>Nouvel LI</li>"

      // On créé un élément
      const nouvelLI = document.createElement("li");

      // On défini son contenu textuel
      nouvelLI.textContent = "Nouvel LI";

      // On lui ajoute une fonction en cas de clic sur ce dernier
      nouvelLI.addEventListener("click", () => {
        console.log("J'ai cliqué sur mon nouvel LIElement!");
      });

      monUL.appendChild(nouvelLI);
    }
  });

  document
    .querySelector("input#mon-input")
    ?.addEventListener("input", (event) => {
      console.log(event.target.value);
      if (document.querySelector("span#result-input")) {
        document.querySelector("span#result-input").textContent =
          event.target.value;
      }
    });
});

console.log("Dés le début");

const maFonction = () => {
  console.log("J'exécute la fonction");
};
