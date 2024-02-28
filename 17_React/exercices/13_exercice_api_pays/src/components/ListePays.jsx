import React, { useContext } from "react";
import { PaysContext } from "../context/PaysContext";

const ListePays = () => {
  const { listePays } = useContext(PaysContext);

  return (
    <>
      {listePays && (
        <section id="liste-pays">
          {listePays.map((pays, index) => (
            <div key={index} className="card m-2" style={{width: "30%"}}>
              <img src={pays.flags.png} alt={pays.flags.alt} />         
              <p>Nom: {pays.translations.fra.official} </p>  
              <p>Capitale: {pays.capital}</p>  
              <p>Continent: {pays.region} </p> 
              <p>Population du pays: {pays.population} habitants</p>
            </div>
          ))}
        </section>
      )}
    </>
  );
};

export default ListePays;
