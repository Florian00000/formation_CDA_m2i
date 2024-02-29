import { useSelector } from "react-redux";

const TaskHeader = () => {
  const counter = useSelector(state => state.task.counterTask)
  return ( 
    <header>
      <h1>React Todo List :</h1>
      <p>Tâches à faire : {counter}</p>
    </header>
   );
}
 
export default TaskHeader;