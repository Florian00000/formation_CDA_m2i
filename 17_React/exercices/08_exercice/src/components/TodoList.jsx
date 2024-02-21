import React from 'react';

const TodoList = (props) => {
    let {todoList, updateTodo, deleteTodo} = props;

    const todoDone = (index) => {
        updateTodo(index);
    }

    const delTodo = (index) => {
        deleteTodo(index)
    }

    return (
        <div className='card bg-dark text-light ms-1' id='todoList'>
            <h3>Todos</h3>
            <hr />
            {todoList.map((todo, index) =>
            <div key={index} className='card bg-dark border-light mb-2 text-light'>
                <div className='d-flex'>
                <p className='me-auto'> {todo.titre}</p>
                <p> {todo.dateLimite.toLocaleDateString()} </p>
                </div>
                <hr />
                <p> {todo.description} </p>
                <div className='d-flex'>
                { todo.statut ?                  
                <button className='btn btn-success' onClick={()=> todoDone(index)} >Fait</button>: 
                <button className='btn btn-warning' onClick={()=> todoDone(index)}>A faire</button>}
                <button className='btn btn-danger ms-auto' onClick={()=> delTodo(index) } >Supprimer</button>

                </div>
            </div>
            )}
        </div>
    );
}

export default TodoList;
