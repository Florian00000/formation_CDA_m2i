import React from 'react';
import { useRef, useContext } from 'react';
import axios from 'axios';
import { TodoContext } from "../context/TodoContext";

const EditTodo = (props) => {
    let {idTodo, changeModal} = props;
    const {todosList, nouveauRendu} = useContext(TodoContext);

    const nomRef = useRef();
    const descriptionRef = useRef();

    const nomTodo = todosList.find(todo => todo.id == idTodo).nom;
    const descriptionTodo = todosList.find(todo => todo.id == idTodo).description

    const updateTodo = (e) => {
        e.preventDefault();

        const updatedTodo = {
            nom: nomRef.current.value,
            description: descriptionRef.current.value
        }

        axios.put(`http://localhost:3000/todos/${idTodo}`, updatedTodo)
        .then(nouveauRendu)
        .catch(error => console.error(error));
        changeModal();
    }

    return (
        <>
            <form onSubmit={updateTodo} style={{borderRadius: "1rem"}}>
            <div>
                <label htmlFor="nom" className='form-label'>Nom de la tâche:</label>
                <input type="text" id='nom' className='form-control' required ref={nomRef} defaultValue={nomTodo} />
            </div>
            <div>
                <label htmlFor="description" className='form-label'>Description de la tâche:</label>
                <input type="text" id='description' className='form-control' required ref={descriptionRef} defaultValue={descriptionTodo}/>
            </div>
            <button type='submit' className='btn btn-primary rounded-1 mt-3 w-100'>Editer</button>
            </form>
        </>
    );
}

export default EditTodo;
