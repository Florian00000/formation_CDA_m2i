import React, { useRef } from 'react';
import { useDispatch } from 'react-redux';
import { addProduct } from './productsSlice';

const AddProduct = () => {
    const nameRef = useRef();
    const descriptionRef = useRef();

    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();     
        const newProduct = {
            id: Date.now(),
            name: nameRef.current.value,
            description: descriptionRef.current.value
        };   
        dispatch(addProduct(newProduct));

        nameRef.current.value = "";
        descriptionRef.current.value = ""
    }

    return (
        <>
        <h2>Ajouter un produit</h2>
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="name" className='label-form'>Nom du produit:</label>
                <input type="text" id='name' className='form-control' ref={nameRef} />
            </div>
            <div>
                <label htmlFor="description" className='label-form'>Description du produit:</label>
                <input type="text" id='description' className='form-control' ref={descriptionRef} />
            </div>
            <button type='submit' className='btn btn-success w-100 mt-2'>Ajouter</button>
        </form>
        </>
    );
}

export default AddProduct;
