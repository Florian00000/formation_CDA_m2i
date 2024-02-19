import React from "react";
import { useState } from "react";

const FizzBuzzExercice3 = () => {
  const [nbFizz, setNbFizz] = useState(15);

  const message = () => {
    if (nbFizz % 3 === 0 && nbFizz % 5 === 0) {
      return "FizzBuzz";
    } else if (nbFizz % 3 === 0) {
      return "Fizz";
    } else if (nbFizz % 5 === 0) {
      return "Buzz";
    } else {
      return nbFizz;
    }
  };

  const increment = () => {
    setNbFizz(nbFizz + 1);
  };

  const decrement = () => {
    setNbFizz(nbFizz - 1);
  };


  return (
    <div>
      <h3>Fizz Buzz</h3>
      <p> {message()} </p>
      <button onClick={decrement} disabled={nbFizz <= 0}>
        Decrement
      </button>
      <button onClick={increment} disabled={nbFizz >= 42}>
        Increment
      </button>

      
    </div>
  );
};

export default FizzBuzzExercice3;
