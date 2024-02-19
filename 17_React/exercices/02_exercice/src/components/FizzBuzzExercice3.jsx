import React from "react";
import { useState } from "react";

const FizzBuzzExercice3 = () => {
  const [nbFizz, setNbFizz] = useState(15);

  const message = () => {
    if (nbFizz % 3 === 0 && nbFizz % 5 === 0) {
      return "FizzBuzz";
    }
    if (nbFizz % 3 === 0) {
      return "Fizz";
    }
    if (nbFizz % 5 === 0) {
      return "Buzz";
    }
    return `${nbFizz}`;
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
      <button onClick={decrement} disabled={nbFizz <=0} >Decrement</button>
      <button onClick={increment} disabled={nbFizz >=4200000000} >Increment</button>
    </div>
  );
};

export default FizzBuzzExercice3;
