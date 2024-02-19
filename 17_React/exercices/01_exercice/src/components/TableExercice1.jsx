import React from "react";

const TableExercice1 = () => {
  const liste = [
    { nom: "George", metier: "cowboy", yaourt: true },
    { nom: "Jack", metier: "facteur", yaourt: false },
  ];

  return (
    <table className="table table-dark">
      <thead>
        <tr>
          <th>#</th>
          <th>nom</th>
          <th>métier</th>
          <th>yaourt???</th>
        </tr>
      </thead>
      <tbody>
        {liste.map((personne, index) => (
          <tr key={index}>
            <td>{index + 1}</td>
            <td>{personne.nom}</td>
            <td>{personne.metier}</td>
            <td>
              {personne.yaourt
                ? "Il mange des yaourts"
                : "Il n'est pas aimé d'Alexandre"}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default TableExercice1;
