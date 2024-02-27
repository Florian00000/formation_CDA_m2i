import React from 'react';

const Form = () => {

    const setStorage = () => {
        localStorage.setItem("token", "mon_token")
    }

    return (
        <>
            <h1>Page d'authentification</h1>
            <button onClick={setStorage}>Identification</button>
        </>
    );
}

export default Form;
