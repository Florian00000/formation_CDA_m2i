let monBouton = document.querySelector("button#btn-ajout");

monBouton.addEventListener("click", () =>  {
    const monInput = document.querySelector("input#mon-input");
    const monUl = document.querySelector("ul#mon-ul");
    if (monInput.value) {
        // On créé un élément
      const nouvelLI = document.createElement("li");

      // On défini son contenu textuel
      nouvelLI.textContent = monInput.value;

      monUl.appendChild(nouvelLI);
    }
});