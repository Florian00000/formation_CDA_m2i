import { useState } from 'react'
import './App.css'
import FormulaireExercice6 from './components/formulaireExercice6'
import TableauContactsExercice6 from './components/tableauContactsExercice6'
import DemoModalPortal from './components/demoModal/demoModalPortal';
import LoginDemoPortal from './components/LoginDemoPortal';
import DemoRef from './components/DemoRef';


function App() {
  const [count, setCount] = useState(0);
  const [listContacts, setListContacts] = useState([]);

  const [isOpen, setIsOpen] = useState(false);

  const ajouterContact= (newContact) => {
    setListContacts([...listContacts, newContact ]);       
  }

  const changeModal = () => {
    setIsOpen(!isOpen)
  }

  return (
    <>
    <h1>Bienvenue</h1>
    <button onClick={ changeModal }>Connexion Modal</button>
    <hr />

      <FormulaireExercice6 ajouterContact={ajouterContact} />

      <hr />
      <TableauContactsExercice6 listContacts={listContacts} />
      <hr />
      {/* Si isOpen est true, on affiche la modale */}
      {isOpen && <DemoModalPortal changeModal={changeModal} > <LoginDemoPortal/> </DemoModalPortal> } 

      <hr />
      <DemoRef/>
      
    </>
  )
}

export default App
