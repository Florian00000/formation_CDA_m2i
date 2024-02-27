import React from 'react';
import { useContext } from 'react';
import { TodoContext } from '../context/TodoContext';
import { useRef } from 'react';
import axios from 'axios';

const TodoForm = () => {
    const {nouveauRendu} = useContext(TodoContext);

    const nomRef = useRef();
    const descriptionRef = useRef();

    const addTodo = (e) => {
        e.preventDefault();
        const newTodo = {
            nom: nomRef.current.value,
            description: descriptionRef.current.value
        };
        axios.post("http://localhost:3000/todos", newTodo)
        .then(nouveauRendu)
        .catch(error => console.error(error));
        nomRef.current.value = "";
        descriptionRef.current.value = "";        
    }

    return (
        <form onSubmit={addTodo} className='card rounded-sm me-5 ' style={{width: "50%"}}>
            <h4 className=''>Ajouter une tâche</h4>
            <div >
                <label htmlFor="nom" className='form-label'>Nom de la tâche:</label>
                <input type="text" id='nom'  className='form-control border-primary' required ref={nomRef}/>
            </div>
            <div>
                <label htmlFor="description" className='form-label'>Description de la tâche:</label>
                <input type="text" id='description' className='form-control border-primary' required ref={descriptionRef}/>
            </div>
            <button type='submit' className='btn btn-outline-primary rounded-1 mt-4'>Ajouter</button>
        </form>
    );
}

export default TodoForm;
