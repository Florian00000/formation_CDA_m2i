import './App.css'
import {Link, Outlet} from 'react-router-dom'
import { useState } from 'react'
import {ContactsContext} from '../src/contexts/ContactsContext';

function App() {

  const [contacts, setContacts] = useState([]);
  let lienCreate;
  if (!contacts.length) {    
    lienCreate = `/contacts/0?mode=create`
  }else {
    let idContact = contacts.length;
    lienCreate = `/contacts/${idContact}?mode=create`
  }

  return (
    <>
      <ContactsContext.Provider value={{contacts, setContacts}} >        

      <nav>
        <Link to={'/contacts'} >List des contacts </Link>
        <span>CRUD </span>
        <Link to={lienCreate}>Ajout d'un contact </Link>
      </nav>


      <main>
      <Outlet/>
      </main>
      </ContactsContext.Provider>
      
    </>
  )
}

export default App
