import { useContext, useRef } from "react";
import { useNavigate, useParams, useSearchParams } from "react-router-dom";
import ContactContext from "../contexts/ContactContext";

const ContactForm = () => {
  const navigate = useNavigate()
  const {contactId} = useParams()
  const [searchParams] = useSearchParams()
  const mode = searchParams.get("mode") ?? "add"

  const {contacts, setContacts} = useContext(ContactContext)
  const contact = contacts.find(contact => contact.id == contactId)

  const firstnameRef = useRef()
  const lastnameRef = useRef()
  const emailRef = useRef()
  const phoneRef = useRef()

  const submitFormHandler = (e) => {
    e.preventDefault()

    if(mode === "delete") {
      setContacts((prev) => prev.filter(contact => contact.id != contactId))
      
    } else if (mode === "edit") {
      const updatedContact = {
        id: contactId,
        firstname: firstnameRef.current.value,
        lastname: lastnameRef.current.value,
        email: emailRef.current.value,
        phone: phoneRef.current.value
      }
      
      setContacts(prev => prev.map(contact => contact.id == contactId ? updatedContact : contact))
    } else {
      const newContact = {
        id: Date.now(),
        firstname: firstnameRef.current.value,
        lastname: lastnameRef.current.value,
        email: emailRef.current.value,
        phone: phoneRef.current.value      
      }

     
      setContacts((prev) => [...prev, newContact])
    }
    navigate("/contacts")
  }

  return ( 
    <>
      <h3>{mode} Contact</h3>
      <hr />
      <form onSubmit={submitFormHandler}>
        <div>
          <label htmlFor="firstname">Firstname</label>
          <input type="text" required={mode != "delete"} disabled={mode === 'delete'} ref={firstnameRef} defaultValue={contact?.firstname} />
        </div>
        <div>
          <label htmlFor="lastname">Lastname</label>
          <input type="text" required={mode != "delete"} disabled={mode === 'delete'} ref={lastnameRef} defaultValue={contact?.lastname} />
        </div>
        <div>
          <label htmlFor="email">Email</label>
          <input type="email" required={mode != "delete"} disabled={mode === 'delete'} ref={emailRef} defaultValue={contact?.email} />
        </div>
        <div>
          <label htmlFor="phone">Phone</label>
          <input type="text" required={mode != "delete"} disabled={mode === 'delete'} ref={phoneRef} defaultValue={contact?.phone} />
        </div>
        <button>{mode}</button>
      </form>
    </>
   );
}
 
export default ContactForm;