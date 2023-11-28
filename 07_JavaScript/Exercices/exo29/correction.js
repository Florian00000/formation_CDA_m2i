
// Fonction pour mettre un texte en Capitilized (première lettre uniquement en majuscule)
const toCapitilize = (text) => {
  return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase()
}

// On attend le chargement du DOM pour réaliser notre code
document.addEventListener("DOMContentLoaded", () => {

  // On va sélectionner les deux inputs via .querySelectorAll() et réaliser du code en commun pour les deux via une boucle .forEach()
  document.querySelectorAll("form div input").forEach((element) => {
    // Pour chaqu'un de nos input, on va se brancher sur leur évènement 'input' (saisie utilisateur)
    element.addEventListener('input', () => {

      // On récupère la valeur de l'input
      const elementValue = element.value;

      // On récupère la <div> parent de notre input pour la suite du code
      const divElement = element.parentElement;

      // Si pas de valeur...
      if (!elementValue) {

        // On change la couleur de fond en rouge
        element.style.backgroundColor = "red";
        // On rend le bouton non cliquable
        document.querySelector('form div button').disabled = true;

        // ON créé un objet de paragraphe
        const newParagraphElement = document.createElement('p')

        // On défini le contenu en texte du paragraphe
        newParagraphElement.textContent = toCapitilize(element.name) + " is not valid!"
        // On ajoute un paragraphe d'avertissement sous les champs
        divElement.appendChild(newParagraphElement)
      } else {

        // On passe la couleur de fond en blanc
        element.style.backgroundColor = "white";

        // On rend le bouton cliquable
        document.querySelector('form div button').disabled = false;

        // On cherche le paragraphe d'avertissement
        const paragraphElement = divElement.querySelector('p')

        // Si trouvé, on le retire du DOM
        if (paragraphElement) divElement.removeChild(paragraphElement)
      }
    })
  });
});
