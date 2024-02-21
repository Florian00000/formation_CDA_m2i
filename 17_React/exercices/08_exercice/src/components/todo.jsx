import React, { useState } from 'react';
import TodoForm from './TodoForm';
import TodoList from './TodoList';

const Todo = () => {
    const [todoList, setTodoList] = useState([]) 

    const addTodo = (todo) => {
        setTodoList([...todoList, todo])
    }

    const updateTodo = (index) => {    
        const updatedTodoList = [...todoList];
        updatedTodoList[index] = {...updatedTodoList[index], statut: !updatedTodoList[index].statut}; 
        setTodoList(updatedTodoList);                
    }

    const deleteTodo = (index) => {
        const updatedTodoList = [...todoList];
        updatedTodoList.splice(index, 1)
        setTodoList(updatedTodoList);

    }

    return (        
        <main className='d-flex container'>
            <TodoForm addTodo={addTodo} />
            <TodoList todoList={todoList} updateTodo={updateTodo} deleteTodo={deleteTodo} />
        </main>
    );
}

export default Todo;
