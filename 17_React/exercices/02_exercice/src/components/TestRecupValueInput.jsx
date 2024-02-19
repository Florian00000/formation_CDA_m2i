import React from "react";
import { useState } from "react";

const TestRecupValueInput = () => {
  const [myText, setMyText] = useState("");

  const textInputHandler = (event) => {
    setMyText(event.target.value);
  };
  return (
    <div>
      <input type="text" value={myText} onInput={textInputHandler} />
      <p> {myText} </p>
    </div>
  );
};

export default TestRecupValueInput;
