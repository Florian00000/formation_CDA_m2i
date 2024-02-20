import { useState } from 'react'
import './App.css'
import FormulaireExercice6 from './components/formulaireExercice6'
import TableauContactsExercice6 from './components/tableauContactsExercice6'

function App() {
  const [count, setCount] = useState(0);
  const [listContacts, setListContacts] = useState([]);

  const ajouterContact= (newContact) => {
    setListContacts([...listContacts, newContact ]);       
  }

  return (
    <>
      <FormulaireExercice6 ajouterContact={ajouterContact} />

      <hr />
      <TableauContactsExercice6 listContacts={listContacts} />
    </>
  )
}

export default App
