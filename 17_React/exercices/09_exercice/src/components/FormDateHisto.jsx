import React, { useContext, useRef } from "react";
import { DateHistoContext } from "../contexts/DateHistoContext";

const FormDateHisto = () => {
  const value = useContext(DateHistoContext);

  //inputs
  const anneeRef = useRef();
  const titreRef = useRef();
  const descriptionRef = useRef();

  const addDateHisto = (e) => {
    e.preventDefault(); 
    const newDateHisto = {
        annee: anneeRef.current.value,
        titre: titreRef.current.value,
        description: descriptionRef.current.value
    }   
    value.setListDatesHisto([...value.listDatesHisto, newDateHisto]);
    console.log(value.listDatesHisto);    
  };

  return (
    <form onSubmit={addDateHisto}>
      <div>
        <label htmlFor="annee">Année de l'événement: </label>
        <input type="number" id="annee" required ref={anneeRef} />
      </div>
      <div>
        <label htmlFor="titre">Titre de l'événement:</label>
        <input type="text" id="titre" required ref={titreRef} />
      </div>
      <div>
        <label htmlFor="description">Description:</label>
        <textarea id="description" cols="30" rows="10" ref={descriptionRef} ></textarea>
      </div>
      <button type="submit">Ajouter</button>
    </form>
  );
};

export default FormDateHisto;
