let peopleCount = 0; // On créé un compteur de personnes
let peoples = []; // On créé un tableau vierge

document.addEventListener("DOMContentLoaded", () => {
  // Ici pour le code afin d'attendre le chargement de la page et éviter les erreurs de récupération des IDs dans l'HTML

  // On écoute le clic du bouton avec l'id 'add-btn'
  document.getElementById("add-btn")?.addEventListener("click", () => {
    // On récupère les élément dans l'HTML
    const firstnameElement = document.getElementById("firstname");
    const lastnameElement = document.getElementById("lastname");
    const birthDateElement = document.getElementById("birthDate");

    // On créé un objet de personne avec les champs id, firstname, lastname et birthDate (certain on leut valeur issue des élément de notre HTML, d'autre via une incrmentation d'une variable numérique)
    const newPeople = {
      id: ++peopleCount,
      firstname: firstnameElement.value,
      lastname: lastnameElement.value,
      birthDate: birthDateElement.value,
    };

    // On ajoute l'objet de personne à notre tableau de personnes
    peoples.push(newPeople);

    // On cible notre balise <tbody>
    const tBody = document.getElementById("tbody-result");

    // On créé une balise <tr>
    const newTR = document.createElement("tr");

    // On parcourt une par une les clés dans l'objet 'newPeople'
    for (const key in newPeople) {
      // On créé une balise <td> pour chaque clé de notre objet
      const newTD = document.createElement("td");

      // ON place dans son contenu la valeur de la clé actuellement parcourue
      newTD.textContent = newPeople[key];

      // On ajoute la cellule du tableau à la ligne de tableau en court de création
      newTR.appendChild(newTD);
    }

    // On ajoute la ligne remplie à notre tableau (à la fin)
    tBody.appendChild(newTR);
  });
});


/*
  const mesInputs = document.getElementsByClassName('mon-input')

  const maPersonne = {}
  for(const element of mesInputs) {
    maPersonne[element.name] = element.value;
  }
*/
