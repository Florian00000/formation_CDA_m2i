import { useContext } from "react";
import {Link} from "react-router-dom"
import ContactContext from "../contexts/ContactContext"
import ContactDisplay from "./ContactDisplay";

const ContactList = () => {
  const {contacts} = useContext(ContactContext)

  return (  
    <div>
      <div>
        <h1>ContactList</h1>
        <Link to={"/contact/add"}>Ajouter contact</Link>
      </div>
      <hr />
      {
        contacts.length === 0 ?
        <p>Il n'y a pas de contact pour le moment</p> :
        contacts.map(contact => (
          <ContactDisplay key={contact.id} contactId={contact.id} />
        ))
      }
    </div>
  );
}
 
export default ContactList;