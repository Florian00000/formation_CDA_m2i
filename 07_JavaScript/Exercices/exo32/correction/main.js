import Chat from "./chat.js";

// On instancie un tableau de chats vierge pour contenir les futurs chats
let chats = [];
// On défini une variable permettant de connaitre le mode du formulaire
let formMode = "Ajouter";
// ON défini une variable permettant de connaitre le chat actuellement en cours d'édition (voir de suppression, etc...)
let chatSelectionne = null;

// ON attend que le DOM soit chargé
document.addEventListener("DOMContentLoaded", () => {
  // Fonction pour trier les chats en se basant sur leur attribut
  const sortCats = () => {
    const attr = document.querySelector("select#cat-sorting").value;

    // chats.sort((a, b) => {
    //   if (a[attr] < b[attr]) return -1;
    //   else return 1;
    // });

    // On trie directement de façon dynamique via la notation obj[variableAttribut]
    chats.sort((a, b) => (a[attr] < b[attr] ? -1 : 1));

    const tBody = document.querySelector("tbody#cat-display");

    // On constitue un tableau (triable) à partir des lignes du tableau
    const rows = Array.from(tBody.children);
    // rows.sort((a, b) => {
    //   if (
    //     chats.find((chat) => chat.id === +a.dataset.catId)[attr] <
    //     chats.find((chat) => chat.id === +b.dataset.catId)[attr]
    //   )
    //     return -1;
    //   else return 1;
    // });

    // Pour trier un tableau dans le DOM, il faut faire un .appendChid() de ce même row mais selon un ordre différent. On va donc:
    // * Trier le tableau
    // * Ajouter les lignes de nouveau dans le bon ordre
    rows
      .toSorted((a, b) =>
        chats.find((chat) => chat.id === +a.dataset.catId)[attr] <
        chats.find((chat) => chat.id === +b.dataset.catId)[attr]
          ? -1
          : 1
      )
      .forEach((row) => tBody.appendChild(row));
  };

  // Fonction pour générer l'affichage du modal (en fonction du mode)
  const showModal = () => {
    // On définir les entête et le contenu du bouton d'envoi du formulaire en se basant sur le mode actuel
    document
      .querySelectorAll("span.form-mode")
      .forEach((element) => (element.textContent = formMode));

    // En cas de chat sélectionné, on peuple les champs du formulaire à partir de ce chat précis
    document.querySelector("input#name").value = chatSelectionne
      ? chatSelectionne.name
      : "";
    document.querySelector("input#breed").value = chatSelectionne
      ? chatSelectionne.breed
      : "";
    document.querySelector("input#birthDate").valueAsDate = chatSelectionne
      ? chatSelectionne.birthDate
      : new Date();

    //   if (formMode === 'Ajouter') {
    //   // On initialise les champs du formulaire avec des valeurs par défaut
    //   document.querySelector("input#name").value = "";
    //   document.querySelector("input#breed").value = "";
    //   document.querySelector("input#birthDate").valueAsDate = new Date();
    // } {
    //   document.querySelector("input#name").value = chatSelectionne.name;
    //   document.querySelector("input#breed").value = chatSelectionne.breed;
    //   document.querySelector("input#birthDate").valueAsDate = chatSelectionne.birthDate;
    //   }

    // On affiche le modal
    modalBgElement.style.display = "flex";
  };

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

    // En cas d'ajout d'un chat...
    if (formMode === "Ajouter") {
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
      // newTRElement.setAttribute("data-cat-id", nouveauChat.id);
      newTRElement.dataset.catId = nouveauChat.id;

      // ON créé une par une les cellules de notre ligne en cours de création
      const idTD = document.createElement("td");
      idTD.textContent = nouveauChat.id;
      const nameTD = document.createElement("td");
      nameTD.textContent = nouveauChat.name;
      const breedTD = document.createElement("td");
      breedTD.textContent = nouveauChat.breed;
      const birthDateTD = document.createElement("td");
      birthDateTD.textContent =
        nouveauChat.birthDate.toLocaleDateString("fr-FR"); // Pour une date, on peut l'afficher au format de la langue voulue grâce à .toLocaleDateString("code-LANG")
      const actionsTD = document.createElement("td");
      const editBTNElement = document.createElement("button");
      editBTNElement.textContent = "Editer";
      editBTNElement.addEventListener("click", () => {
        // En cas d'edition, on doit passer le formulaire en Edition et peupler ses champs via un chat particulier
        formMode = "Editer";
        chatSelectionne = nouveauChat;
        showModal();
      });
      actionsTD.appendChild(editBTNElement);

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
    } else {
      // En cas d'édition, on va modifier les valeurs du chat en cours d'édition par rapport à celles dans le formulaire
      chatSelectionne.name = document.querySelector("input#name").value;
      chatSelectionne.breed = document.querySelector("input#breed").value;
      chatSelectionne.birthDate =
        document.querySelector("input#birthDate").valueAsDate;

      // ON va chercher dans le DOM la ligne du tableau portant le même ID que le chat en cours d'édition
      const rowToEdit = document.querySelector(
        `tr[data-cat-id="${chatSelectionne.id}"]`
      );
      // Si on en trouve une...
      if (rowToEdit) {
        // ON modifier les cellules de la ligne à partir des champs du chat édité
        rowToEdit.children[1].textContent = chatSelectionne.name;
        rowToEdit.children[2].textContent = chatSelectionne.breed;
        rowToEdit.children[3].textContent =
          chatSelectionne.birthDate.toLocaleDateString("fr-FR");
      }
    }

    // On ferme le modal et on trie les chats (pour conserver le mécanisme de tri malgré un ajout ou une édition des données)
    modalBgElement.style.display = "none";
    sortCats();
  });

  // On affiche le modal en cas d'appui sur le bouton 'Ajouter un chat' présent dans la page
  document.querySelector("#btn-add-cat").addEventListener("click", () => {
    // En cas de volonté d'ajout, le formulaire doit passer en mode Ajout et on ne doit pas avoir de peuplement des champs par rapport à un chat particulier
    chatSelectionne = null;
    formMode = "Ajouter";
    showModal();
  });

  document.querySelector("select#cat-sorting").addEventListener("input", () => {
    sortCats();
  });
});
