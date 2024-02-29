import { useDispatch } from "react-redux";
import { deleteTask, toggleTask } from "./TaskSlice";

const TaskItem = (props) => {
  const task = props.task
  // Pour utiliser les fonctions définies dans le slice
  const dispatch = useDispatch()
  return (  
    <div>
      <input type="checkbox" checked={task.done} onChange={() => dispatch(toggleTask(task.id))} />
      <p>{task.text} - {task.done ? "Terminée" : "A faire"}</p>
      <button onClick={() => dispatch(deleteTask(task.id))}>Supprimer</button>
    </div>
  );
}
 
export default TaskItem;