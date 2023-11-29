document.addEventListener("DOMContentLoaded", () => {
  const modal = document.getElementsByClassName("modal")[0];

  document.getElementById("modal-btn-close")?.addEventListener("click", () => {
    modal.style.display = "none";
  });

  modal.addEventListener("click", (event) => {
    if (event.target === event.currentTarget) modal.style.display = "none";
  });

  document.getElementById("btn-show-modal")?.addEventListener("click", () => {
    modal.style.display = "flex";
  });

  // Pour rendre disponible la suppression d'un élément du DOM dés sa création

  ["John", "Martha", "Chloée"].forEach((p, i) => {
    const newLIElement = document.createElement("li");
    newLIElement.textContent = p;
    // newLIElement.className = "vos classes"
    // newLIElement.classList.add("nouvelle-classe")
    newLIElement.setAttribute("data-demo-person-name", p);
    newLIElement.addEventListener("click", () => {
      newLIElement.remove();
    });

    document.getElementById("mon-ul")?.appendChild(newLIElement);

    const newTRElement = document.createElement("tr");
    const idTDElement = document.createElement("td");
    idTDElement.textContent = i;
    const nameTDElement = document.createElement("td");
    nameTDElement.textContent = p;
    const actionsTDElement = document.createElement("td");
    const deleteBTNElement = document.createElement("button");
    deleteBTNElement.textContent = "Delete";
    deleteBTNElement.addEventListener("click", () => {
      newTRElement.remove();
    });
    actionsTDElement.appendChild(deleteBTNElement);
    newTRElement.appendChild(idTDElement);
    newTRElement.appendChild(nameTDElement);
    newTRElement.appendChild(actionsTDElement);
    document.getElementById("mon-tbody")?.appendChild(newTRElement);
  });

  document.getElementById("delete-btn")?.addEventListener("click", () => {
    const value = document.getElementById("id-to-del")?.value;

    if (value) {
      console.log(value);
      const elementFound = document.querySelector(
        `[data-demo-person-name="${value}"]`
      );
      // elementFound.textContent = "FOUND !";
      elementFound?.remove();
    }
  });
});
