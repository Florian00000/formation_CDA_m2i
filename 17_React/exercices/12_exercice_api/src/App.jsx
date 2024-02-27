import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import { TodoContext } from "./context/TodoContext";
import TodosList from "./components/TodosList";
import TodoForm from "./components/TodoForm";
import 'bootstrap/dist/css/bootstrap.min.css';

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
      <h1>Exercice 12 Api</h1>
      <div style={{display: "flex"}}>

      <TodoContext.Provider value={{todosList, setTodosList, nouveauRendu}}>
        <TodoForm/>
        <hr />
        <TodosList/>
      </TodoContext.Provider>
      </div>
    </>
  );
}

export default App;
