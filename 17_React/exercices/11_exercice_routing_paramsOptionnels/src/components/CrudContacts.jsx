import React from "react";
import { useContext } from "react";
import { useParams, useSearchParams, useNavigate } from "react-router-dom";
import { ContactsContext } from "../contexts/ContactsContext";
import { useRef } from "react";
import { Link } from "react-router-dom";

const CrudContacts = () => {
  const { idContact } = useParams();
  const [searchParams, setSearchParams] = useSearchParams();
  const mode = searchParams.get("mode");

  const contactsContext = useContext(ContactsContext);

  const navigateTo = useNavigate();
  
  const nomRef = useRef();
  const prenomRef = useRef();
  const emailRef = useRef();
  const telRef = useRef();

  //create
  const addContact = (e) => {
    e.preventDefault();
    const newContact = {
      id: idContact,
      nom: nomRef.current.value,
      prenom: prenomRef.current.value,
      email: emailRef.current.value,
      tel: telRef.current.value,
    };
    contactsContext.setContacts([...contactsContext.contacts, newContact]);    
    navigateTo('/contacts')
  };

  //update
   const editContact = (e) => {
    e.preventDefault();
    const contactUpdated = {
      id: idContact,
      nom: nomRef.current.value,
      prenom: prenomRef.current.value,
      email: emailRef.current.value,
      tel: telRef.current.value,
    };
    const updatedList = [...contactsContext.contacts];
    updatedList[idContact] = contactUpdated;
    contactsContext.setContacts(updatedList);
    navigateTo('/contacts');
   }

   //delete
   const deleteContact = () => {
    const updatedList = [...contactsContext.contacts];
    updatedList.splice(idContact, 1);
    contactsContext.setContacts(updatedList);
    navigateTo('/contacts');
   }
   
 if (mode === 'create') {
    return (
        <form onSubmit={addContact}>
          <h3>Ajouter un contact</h3>
          <hr />
          <div>
            <label htmlFor="nom">Nom:</label>
            <input type="text" id="nom" required ref={nomRef}/>
          </div>
          <div>
            <label htmlFor="prenom">Prénom:</label>
            <input type="text" id="prenom" required ref={prenomRef} />
          </div>
          <div>
            <label htmlFor="email">email:</label>
            <input type="email" id="email" required ref={emailRef} />
          </div>
          <div>
            <label htmlFor="tel">Téléphone:</label>
            <input type="text" id="tel" required ref={telRef}/>
          </div>
          <button type="submit"> Ajouter</button>
        </form>
      );
 } else if (mode === 'update') {
    return (
        <form onSubmit={editContact}>
          <h3>Editer un contact</h3>
          <hr />
          <div>
            <label htmlFor="nom">Nom:</label>
            <input type="text" id="nom" required ref={nomRef} placeholder={contactsContext.contacts[idContact].nom} />
          </div>
          <div>
            <label htmlFor="prenom">Prénom:</label>
            <input type="text" id="prenom" required ref={prenomRef} placeholder={contactsContext.contacts[idContact].prenom} />
          </div>
          <div>
            <label htmlFor="email">email:</label>
            <input type="email" id="email" required ref={emailRef} placeholder={contactsContext.contacts[idContact].email}/>
          </div>
          <div>
            <label htmlFor="tel">Téléphone:</label>
            <input type="text" id="tel" required ref={telRef} placeholder={contactsContext.contacts[idContact].tel}/>
          </div>
          <button type="submit">Editer</button>
        </form>
      );
 } else if(mode === 'delete') {
    return (
        < >
        <h3>Suppresion du contact: {contactsContext.contacts[idContact].nom} {contactsContext.contacts[idContact].prenom} </h3>
        <button onClick={deleteContact}>Confirmer</button>
        <Link to={'/contacts'} > <button>Annuler la Suppression</button></Link>
        </>
    )
 } 


  
    
  
  
};

export default CrudContacts;
