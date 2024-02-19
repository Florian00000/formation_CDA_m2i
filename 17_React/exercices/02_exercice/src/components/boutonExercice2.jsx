import React from "react";
import TableauExercice2 from "./TableauExercice2";

const BoutonExercice2 = () => {
  let listeTab = [
    { nom: "George", metier: "cowboy" },
    { nom: "Jack", metier: "facteur" },
  ];

  const newElement = { nom: "test", metier: "test" };

  const ajoutElement = () => {
    listeTab.push(newElement);
    console.log(listeTab);
  };

  return (
    <div>
      <TableauExercice2 listeTab={listeTab} />
      {/* <div>
        <div>
          <label htmlFor="name" className="form-label">Nom:</label>
          <input type="text" id="name" className="form-control"/>
        </div>
        <div>
          <label htmlFor="metier" className="form-label">Métier:</label>
          <input type="text" id="metier" className="form-control"/>
        </div>
      </div> */}
      <button onClick={ajoutElement} className="btn btn-primary">
        Ajout Element
      </button>
    </div>
  );
};

export default BoutonExercice2;
