import React from "react";
import { useState } from "react";

const InputExercice4 = () => {
  const [lastName, setLastName] = useState("");
  const [name, setName] = useState("");

  const changeLastName = (event) => {
    setLastName(event.target.value);
  };

  const changeName = (event) => {
    setName(event.target.value);
  };

  return (
    <div>
      <div>
        <label htmlFor="lastName">Votre Nom</label>
        <input type="text" id="lastName" value={lastName} onInput={changeLastName}/>
      </div>
      <div>
        <label htmlFor="name">Votre Prénom:</label>
        <input type="text" id="name" value={name} onInput={changeName} />
      </div>
      <div>
        <p> Bonjour <b> { `${name} ${lastName.toUpperCase()} `} </b>bienvenue sur l'application          
        </p>
      </div>
    </div>
  );
};

export default InputExercice4;
