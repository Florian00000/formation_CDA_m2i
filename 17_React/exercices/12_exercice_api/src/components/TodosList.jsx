import React from 'react';
import { useContext } from 'react';
import { TodoContext } from '../context/TodoContext';
import axios from 'axios';
import { useState } from 'react';
import Modal from './modal/modal';
import EditTodo from './EditTodo';

const TodosList = () => {
    const {todosList, setTodosList, nouveauRendu} = useContext(TodoContext);
    const [modalUpdate, setModalUpdate] = useState(false);
    const [idEditTodo, setIdEditTodo] = useState()

    const deleteTodo = (idTodo) => {
        axios.delete(`http://localhost:3000/todos/${idTodo}`)
        .then(nouveauRendu)
        .catch(error => console.error(error))
    }

    const changeModal = (idTodo) => {
        setModalUpdate(!modalUpdate)
        setIdEditTodo(idTodo)
    }

    return (
        <>
            {todosList && (
        <table className='table table-dark'>
          <thead>
            <tr >              
              <th>nom</th>
              <th>description</th>
              <th colSpan={2}>Actions</th>
            </tr>
          </thead>
          <tbody>
            {todosList.map((todo) => (
              <tr key={todo.id} className='table-active'>
                <td>{todo.nom} </td>
                <td>{todo.description} </td>
                <td> <button className='btn btn-outline-light rounded-0' onClick={() => changeModal(todo.id)}>Editer</button> </td>
                <td><button className='btn btn-outline-danger rounded-0' onClick={() => deleteTodo(todo.id)}>Supprimer</button></td>
              </tr>
            ))}
          </tbody>
        </table>        
      )}
      {modalUpdate && <Modal changeModal={changeModal} ><EditTodo idTodo={idEditTodo} changeModal={changeModal} /></Modal>}
        </>
    );
}

export default TodosList;
