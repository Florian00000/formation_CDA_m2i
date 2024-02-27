import { useState } from 'react'
import './App.css'
import { RouterProvider } from 'react-router-dom'
import router from './app-routing'
import ContactContext from "./contexts/ContactContext"

function App() {
  const [contacts, setContacts] = useState([])

  return (
    <ContactContext.Provider value={{contacts, setContacts}} >
      <RouterProvider router={router} />
    </ContactContext.Provider>
  )
}

export default App
