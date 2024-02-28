import React, { useContext, useEffect, useRef, useState } from 'react';
import { PaysContext } from '../context/PaysContext';
import axios from 'axios';


const NavBar = () => {
    const rechercheRef = useRef();

    const {setListePays} = useContext(PaysContext);
    const [listeRecherche, setListeRecherche] = useState();

    useEffect(() => {
        axios.get("https://restcountries.com/v3.1/all")
        .then((response) => {          
          setListeRecherche(response.data);
        })
        .catch((error) => console.error(error))
      },[]);
   
    
    const inputRecherche = () => {       
        const regex = new RegExp(rechercheRef.current.value, 'i');  

        const updatedList = listeRecherche.filter((pays) => regex.test(pays.translations.fra.official) || regex.test(pays.translations.fra.common) )              
        setListePays(updatedList);      
    }

    return (
       <nav className='navbar navbar-expand-lg bg-dark mb-3'>
        <span className='navbar-brand text-light'>Exercice 13 Api des Pays</span>
        
        <input type="text" placeholder='Rechercher par pays' className='form-control' onInput={inputRecherche} ref={rechercheRef} />
       </nav>
    );
}

export default NavBar;
