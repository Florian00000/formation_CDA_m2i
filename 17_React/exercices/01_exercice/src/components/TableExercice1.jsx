import React from "react";

const TableExercice1 = () => {
  const liste = [{nom: "George", metier: "cowboy"}, {nom:"Jack", metier: "facteur"}]

  return (
    <table>
      <thead>
        
          <th>nom</th>
          <th>métier</th>
        
      </thead>
      <tbody>
        
          {liste.map((personne, index) => 
          <tr key={index}> 
            <td>{personne.nom}</td>
            <td>{personne.metier}</td>
          </tr> 
          )}
        
      </tbody>
    </table>
  );
};

export default TableExercice1;
