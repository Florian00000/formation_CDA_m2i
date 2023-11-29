import Chat from "./chat.js";

let chats = [];

// ON attend que le DOM soit chargé
document.addEventListener("DOMContentLoaded", () => {
  // On met la date d'aujourd'hui en valeur par défaut de notre formulaire d'ajout de chat (user-friendly)
  document.querySelector("input#birthDate").valueAsDate = new Date();

  const modalBgElement = document.querySelector(".modal-background");

  // On cherche à masquer le modal en cas de clic sur la partie semi-transparente (le fond)
  modalBgElement.addEventListener("click", (event) => {
    if (event.currentTarget === event.target)
      modalBgElement.style.display = "none";
  });

  // On masque le modal en cas d'appui sur la croix présente dans ce dernier
  document.querySelector("#btn-modal-close").addEventListener("click", () => {
    modalBgElement.style.display = "none";
  });

  // On réalise la majorité de notre code en cas d'envoi du formulaire d'ajout de chat (ajout au tableau JS, ajout au DOM, masquer le modal)
  document.querySelector("#form-cat").addEventListener("submit", (event) => {
    // On évite le rafraichissement de la page
    event.preventDefault();

    // On créé un nouvel objet de chat (pour incrémenter l'ID)
    const nouveauChat = new Chat(
      document.querySelector("input#name").value,
      document.querySelector("input#breed").value,
      document.querySelector("input#birthDate").valueAsDate
    );

    // On ajoute le chat au tableau de chats
    chats.push(nouveauChat);

    // On créé une ligne de tableau
    const newTRElement = document.createElement("tr");

    // ON créé une par une les cellules de notre ligne en cours de création
    const idTD = document.createElement("td");
    idTD.textContent = nouveauChat.id;
    const nameTD = document.createElement("td");
    nameTD.textContent = nouveauChat.name;
    const breedTD = document.createElement("td");
    breedTD.textContent = nouveauChat.breed;
    const birthDateTD = document.createElement("td");
    birthDateTD.textContent = nouveauChat.birthDate.toLocaleDateString("fr-FR"); // Pour une date, on peut l'afficher au format de la langue voulue grâce à .toLocaleDateString("code-LANG")
    const actionsTD = document.createElement("td");
    const deleteBTNElement = document.createElement("button");
    deleteBTNElement.textContent = "Delete";

    // On créé un évènement de clic sur le bouton de la ligne actuelle, cet evènement va supprimer la ligne actuellement en cours de création si à l'avenir l'utilisateur cliquera sur le bouton
    deleteBTNElement.addEventListener("click", () => {
      newTRElement.remove();
      chats = chats.filter((chat) => chat !== nouveauChat);
    });
    actionsTD.appendChild(deleteBTNElement);

    newTRElement.appendChild(idTD);
    newTRElement.appendChild(nameTD);
    newTRElement.appendChild(breedTD);
    newTRElement.appendChild(birthDateTD);
    newTRElement.appendChild(actionsTD);

    document.querySelector("#cat-display")?.appendChild(newTRElement);

    // On réinitialise les champs du formulaire
    document.querySelector("input#name").value = "";
    document.querySelector("input#breed").value = "";
    document.querySelector("input#birthDate").valueAsDate = new Date();

    modalBgElement.style.display = "none";
  });

  // On affiche le modal en cas d'appui sur le bouton 'Ajouter un chat' présent dans la page
  document.querySelector("#btn-add-cat").addEventListener("click", () => {
    modalBgElement.style.display = "flex";
  });
});
