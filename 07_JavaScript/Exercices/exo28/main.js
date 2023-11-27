let monBouton = document.querySelector("button#btn-ajout");
let tablePersonne = [];
let compteurPersonne = 2 ;

monBouton.addEventListener("click", () => {
  const nom = document.querySelector("input#nom");
  const prenom = document.querySelector("input#prenom");
  const dateNaissance = document.querySelector("input#dateNaissance");


  const tableau = document.querySelector("table#tableau").getElementsByTagName('tbody')[0];
  if (nom.value && prenom.value && dateNaissance.value) {

    const personne = {
      firstname: prenom.value,
      lastname: nom.value,
      birthDate: dateNaissance.value,
    }

    tablePersonne.push(personne);

    console.table(tablePersonne);       

    const row = tableau.insertRow();
    const idPersonne = row.insertCell();
    idPersonne.textContent = compteurPersonne;
    compteurPersonne ++;

    for (const key in personne) {
      const cel = row.insertCell();
      cel.textContent = personne[key];
    }

    //Sans la boucle for
    // const nomPersonne = row.insertCell();
    // nomPersonne.textContent = nom.value;

    // const prenomPersonne = row.insertCell();
    // prenomPersonne.textContent = prenom.value;

    // const datePersonne = row.insertCell();
    // datePersonne.textContent = dateNaissance.value;
  }
});

