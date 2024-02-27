import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import { TodoContext } from "./context/TodoContext";
import TodosList from "./components/TodosList";
import TodoForm from "./components/TodoForm";

function App() {
  const [todosList, setTodosList] = useState();
  const [changeBdd, setChangeBdd] = useState(false)
 
  const nouveauRendu = () => {
    setChangeBdd(!changeBdd)
  } 

  useEffect(() => {
    axios
      .get("http://localhost:3000/todos")
      .then((response) => {
        console.log(response);
        setTodosList(response.data);
      })
      .catch((error) => console.error(error));
  }, [changeBdd]);

  return (
    <>
      <TodoContext.Provider value={{todosList, setTodosList, nouveauRendu}}>
        <TodoForm/>
        <hr />
        <TodosList/>
      </TodoContext.Provider>
    </>
  );
}

export default App;
