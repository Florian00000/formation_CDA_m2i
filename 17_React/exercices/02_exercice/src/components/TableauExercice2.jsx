import React from 'react';



const TableauExercice2 = (props) => {   
    
    let {listeTab} = props;
    
    return (
        <table className="table table-dark">
      <thead>
        <tr>
          <th>#</th>
          <th>nom</th>
          <th>métier</th>         
        </tr>
      </thead>
      <tbody>
        {listeTab.map((personne, index) => (
          <tr key={index}>
            <td>{index + 1}</td>
            <td>{personne.nom}</td>
            <td>{personne.metier}</td>            
          </tr>
        ))}
      </tbody>
    </table>
    );
}

export default TableauExercice2;
