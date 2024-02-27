import { useContext } from "react";
import {Link} from "react-router-dom"
import ContactContext from "../contexts/ContactContext";

const ContactDisplay = ({contactId}) => {
  const {contacts} = useContext(ContactContext)
  const contact = contacts.find(contact => contact.id === contactId)

  return ( 
    <>
      <h3>{contact.firstname} {contact.lastname}</h3>
      <Link to={`/contact/edit/${contactId}?mode=edit`}>Modifier le contact</Link>
      <Link to={`/contact/delete/${contactId}?mode=delete`}>Supprimer le contact</Link>
      <ul>
        <li>Email : {contact.email}</li>
        <li>Numéro de téléphone : {contact.phone}</li>
      </ul>
    </>
   );
}
 
export default ContactDisplay;