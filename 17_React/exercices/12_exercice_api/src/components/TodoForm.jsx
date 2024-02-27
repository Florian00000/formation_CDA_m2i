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
        <form onSubmit={addTodo}>
            <div>
                <label htmlFor="nom">Nom de la tâche:</label>
                <input type="text" id='nom' required ref={nomRef} />
            </div>
            <div>
                <label htmlFor="description">Description de la tâche:</label>
                <input type="text" id='description' required ref={descriptionRef}/>
            </div>
            <button type='submit'>Ajouter</button>
        </form>
    );
}

export default TodoForm;
