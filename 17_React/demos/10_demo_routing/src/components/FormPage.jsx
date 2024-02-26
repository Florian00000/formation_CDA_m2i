import React from 'react';
import { Link } from 'react-router-dom';

const FormPage = () => {
    return (
        <>
            <Link to={'/'}>Home</Link>
            <h1>Mon formulaire</h1>
            <input type="text" />
            <input type="text" />
        </>
    );
}

export default FormPage;
