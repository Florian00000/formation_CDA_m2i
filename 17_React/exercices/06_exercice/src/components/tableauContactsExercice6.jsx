import React from "react";

const TableauContactsExercice6 = (props) => {
  let { listContacts } = props;



  if (listContacts.length > 0) {
    return (
      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>prénom</th>
            <th>nom</th>
            <th>email</th>
          </tr>
        </thead>
        <tbody>
          {listContacts.map((contact, index) => 
            <tr key={index}>
              <td>{index}</td>
              <td>{contact.firstName}</td>
              <td>{contact.lastName}</td>
              <td>{contact.email}</td>
            </tr>
          )}
        </tbody>
      </table>
    );
  } else {
    return <p> La liste de contact est vide </p>;
  }
};

export default TableauContactsExercice6;
