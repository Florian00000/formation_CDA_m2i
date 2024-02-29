import { useSelector } from "react-redux";
import TaskItem from "./TaskItem";

const TaskList = () => {
  const tasks = useSelector(state => state.task.tasks)

  return ( 
    <>
      {
        tasks.map((task, index) => (
          <TaskItem task={task} key={index} />
        ))
      }
    </>
   );
}
 
export default TaskList;