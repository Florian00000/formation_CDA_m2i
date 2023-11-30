import { Musique } from "./classes.js";

let tableauMusiques = [];

document.addEventListener("DOMContentLoaded", () => {
  //Partie gestion de la modale du formulaire de création de musique
  const modal = document.getElementsByClassName("modal")[0];

  document.getElementById("modal-creer-fermer")?.addEventListener("click", () => {
    modal.style.display = "none";
  });

  document.getElementById("bouton-creer")?.addEventListener("click", () => {
    modal.style.display = "flex";
  });
  
  modal.addEventListener("click", (event) => {
    if (event.target === event.currentTarget) modal.style.display = "none";
  });


  //On écoute l'envoie du formulaire pour créer des musiques
  document.getElementById("form-creer").addEventListener("submit", (event) => {
    event.preventDefault();

    const nomMusique = document.getElementById("nom");
    const artisteMusique = document.getElementById("artiste");
    const anneeMusique = document.getElementById("annee");

    //On créer l'objet musique à partir des informations reçues dans le formulaire et on insère cet objet dans un tableau
    const musique = new Musique (nomMusique.value, artisteMusique.value, anneeMusique.value);
    tableauMusiques.push(musique);
    console.log(tableauMusiques);

    //On modifie le tableau de la page principale
    const tableHtml = document.querySelector("table tbody");
    const row = tableHtml.insertRow();
    row.setAttribute("data-exo32-id-musique", musique.id);

    for (const key in musique) {
      row.insertCell().textContent = musique[key];
      // console.log(musique[key]);
    }

    // On créer un bouton pour la suppression
    const boutonSuppression = document.createElement("button");
    boutonSuppression.textContent = "Suppression";
    boutonSuppression.addEventListener("click", () => {
      row.remove();
      tableauMusiques = tableauMusiques.filter((autresMusiques) => autresMusiques !== musique)
      console.log(tableauMusiques);
    });
    row.insertCell().appendChild(boutonSuppression);

    //On créer un bouton pour l'édition
    const boutonEdition = document.createElement("button");
    boutonEdition.textContent = "Editer";
    boutonEdition.setAttribute("data-exo32-id-musique-bouton", musique.id)
    //On gère le formulaire d'édition
    boutonEdition.addEventListener("click", () => { 
      const modalEdition = document.getElementById("modal-edition");
      modalEdition.style.display = "flex";


    });
    row.insertCell().appendChild(boutonEdition);
    
    //On ferme le formulaire de création
    modal.style.display = "none";
  })
  
  //Partie gestion de la modale du formulaire d'édition de musique 
  const modalEdition = document.getElementById("modal-edition");
  document.getElementById("modal-editer-fermer")?.addEventListener("click", () => {
    modalEdition.style.display = "none";
  });
  
  modalEdition.addEventListener("click", (event) => {
    if (event.target === event.currentTarget) modalEdition.style.display = "none";
  });  
  
  
  // gestion du formulaire d'édition
  document.getElementById("form-editer").addEventListener("submit", (event) => {
    event.preventDefault();



    const idMusique = document.getElementById("id-editer");
    const nomMusique = document.getElementById("nom-editer");
    const artisteMusique = document.getElementById("artiste-editer");
    const anneeMusique = document.getElementById("annee-editer");

    if (idMusique) {            
      document.querySelector(`[data-exo32-id-musique="${idMusique.value}"] td:nth-child(2)`).textContent = nomMusique.value;      
      document.querySelector(`[data-exo32-id-musique="${idMusique.value}"] td:nth-child(3)`).textContent = artisteMusique.value;
      document.querySelector(`[data-exo32-id-musique="${idMusique.value}"] td:nth-child(4)`).textContent = anneeMusique.value;
      let editMusique = tableauMusiques.find((element)=> element?.id == idMusique.value);
      editMusique.editerMusique(nomMusique.value, artisteMusique.value, anneeMusique.value);
    }

    //On ferme le formulaire de création
    modalEdition.style.display = "none";

  })

});
