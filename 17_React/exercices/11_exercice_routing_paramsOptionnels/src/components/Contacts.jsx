import React from "react";
import { ContactsContext } from "../contexts/ContactsContext";
import { useContext } from "react";
import { Link } from "react-router-dom";

const Contacts = () => {
  const contactsContext = useContext(ContactsContext);

  return (
    <>
      <h1>exercice 11 Router Params Optionnels</h1>

      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>nom</th>
            <th>prénom</th>
            <th>email</th>
            <th>téléphone</th>
            <th colSpan={2}>Actions</th>
          </tr>
        </thead>
        <tbody>
          {contactsContext.contacts.map((contact, index) => (
            <tr key={index}>
              <td> {contact.id} </td>
              <td> {contact.nom} </td>
              <td> {contact.prenom} </td>
              <td> {contact.email} </td>
              <td> {contact.tel} </td>
              <td>
                <Link to={`/contacts/${contact.id}?mode=update`}><button>Editer</button></Link>
              </td>
              <td>
                <Link to={`/contacts/${contact.id}?mode=delete`}><button>Supprimer</button></Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default Contacts;
