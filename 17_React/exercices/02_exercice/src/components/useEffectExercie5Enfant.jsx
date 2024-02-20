import React, { useEffect, useState } from "react";

const UseEffectExercie5Enfant = (props) => {
  let { numberProps } = props;

  const [number1, setNumber1] = useState(0);
  const [number2, setNumber2] = useState(0);
  const [egalite, setEgalite] = useState(false);

  const number1Handler = (e) => {
    setNumber1( Number( e.target.value))
  };

  const number2Handler = (e) => {
    setNumber2( Number(e.target.value) )
  };

  useEffect(() => {        
    if (number1 * number2 === numberProps) {
        setEgalite(true)
    }else {
        setEgalite(false)
    }
  }, [number1, number2]);  

  

  const message = () => {
    if (egalite) {
        return `La multiplication des deux nombre fait bien ${numberProps}`
    } else {
        return `Les deux nombres multipliés ne font pas ${numberProps}`
    }
  }

  return (
    <div>
      <div>
        <label htmlFor="number1">Nombre 1:</label>
        <input type="number" id="number1" value={number1} onInput={number1Handler}/>        
      </div>
      <div>
        <label htmlFor="number2">Nombre 2:</label>
        <input type="number" id="number2" value={number2} onInput={number2Handler} />        
      </div>
      <p> {message()} </p>
    </div>
  );
};

export default UseEffectExercie5Enfant;
