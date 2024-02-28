import { useEffect, useState } from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { PaysContext } from './context/PaysContext';
import ListePays from './components/ListePays';
import NavBar from './components/NavBar';

function App() {
  const [listePays, setListePays] = useState();    
  

  useEffect(() => {
    axios.get("https://restcountries.com/v3.1/all")
    .then((response) => {
      // console.log(response);
      setListePays(response.data);
      console.log(listePays);
    })
    .catch((error) => console.error(error))
  },[]);

  return (
    <>

      <PaysContext.Provider value={{listePays,setListePays}}>
        <NavBar/>
      <h1>Exercice 13 Api des Pays</h1>
      <ListePays/>
      </PaysContext.Provider>
    </>
  )
}

export default App
