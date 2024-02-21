import React, { useRef } from 'react';

const TodoForm = (props) => {
    let {addTodo} = props;

    const titreRef = useRef();
    const descriptionRef = useRef();
    const dateLimiteRef = useRef();
    
    const addForm = (e) => {
        e.preventDefault();
        const newTodo = {
            titre: titreRef.current.value,
            description: descriptionRef.current.value,
            dateLimite: new Date (dateLimiteRef.current.value) ,
            statut: false
        };
        addTodo(newTodo);
        titreRef.current.value = "";
        descriptionRef.current.value = "";
        dateLimiteRef.current.value = "";
    }

    return (
        <form onSubmit={addForm} className='card bg-dark text-light me-1' id='todoForm'>
            <h3>TodoForm</h3>
            <hr />

            <div>
                <label htmlFor="titre" className='form-label'>Titre:</label>
                <input type="text" id='titre' className='form-control' ref={titreRef} />
            </div>
            <div>
                <label htmlFor="description" className='form-label mt-2'>Description:</label>
                <textarea  id="description" cols="30" rows="10" className='form-control' ref={descriptionRef} ></textarea>
            </div>
            <div>
                <label htmlFor="dateLimite" className='form-label mt-2'>Date limite</label>
                <input type="date" id="dateLimite" className='form-control' ref={dateLimiteRef} pattern='dd/mm/yyyy' />                
            </div>
            <button type='submit' className='btn btn-outline-light mt-3 ms-auto'>Ajouter</button>
            
        </form>
    );
}

export default TodoForm;
