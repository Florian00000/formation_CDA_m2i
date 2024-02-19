import React from "react";
import TableauExercice2 from "./TableauExercice2";
import { useState } from "react";

const BoutonExercice2 = () => {
  const [listeTab, setListeTab] = useState([
    { nom: "George", metier: "cowboy" },
    { nom: "Jack", metier: "facteur" },
  ]);

  const newElement = { nom: "test", metier: "test" };

  const ajoutElement = () => {
    setListeTab([...listeTab, newElement]);  
    
  };

  return (
    <div>
      <TableauExercice2 listeTab={listeTab} />
      
      <button onClick={ajoutElement} className="btn btn-primary">
        Ajout Element
      </button>
    </div>
  );
};

export default BoutonExercice2;
