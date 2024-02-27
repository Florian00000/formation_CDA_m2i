import { useEffect, useState } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [dataResult, setDataResult] = useState();  

  useEffect(() => {
    axios.get("http://localhost:3000/personnes")
    .then((response) => {
      console.log(response);
      setDataResult(response.data)
    })
    .catch(error => console.error(error));
  }, [dataResult])

  const addPerson = () => {
    axios.post("http://localhost:3000/personnes", {nom: "test"})//json server génère lui même les id
    .then((response) => {
      setDataResult(prev => [...prev, response.data])
    })
    .catch((error) => {
      console.error(error);
    })
  }

  const deletePerson = () => {
    const id = 2

    axios.delete(`http://localhost:3000/personnes/${id}`)
    .then(() => console.log(`La personne avec l'id ${id} a été correctement supprimé`))    
    .catch((error) => {
      console.error(error);
    })
  } 

  const updatePerson = () => {
    const id = 1

    axios.put(`http://localhost:3000/personnes/${id}`, {nom:"Nouveau Nom"})
    .then(response => console.log(response.data))
    .catch(error => console.error(error));
  }

  return (
    <>
      <button onClick={addPerson}>Ajout</button>
      <button onClick={deletePerson} >Supprimer</button>
      <button onClick={updatePerson}>Mettre à jour</button>

      {
        dataResult && (
          <ul>
            {
              dataResult.map((contact) => (
                <li key={contact.id}>{contact.nom} </li>
              ))
            }
          </ul>
        )
      }
    </>
  )
}

export default App
