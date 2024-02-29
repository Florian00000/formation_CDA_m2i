import { useRef } from "react";
import {useDispatch} from "react-redux"
import { addTask } from "./TaskSlice";

const TaskForm = () => {
  const textRef = useRef()
  const dispatch = useDispatch()

  const handleSubmit = (event) => {
    event.preventDefault()
    dispatch(addTask(textRef.current.value))
  }

  return (  
    <>
      <form onSubmit={handleSubmit}>
        <input type="text" ref={textRef} placeholder="Ajouter une tache" />
      </form>
    </>
  );
}
 
export default TaskForm;