import React from 'react';
import { useRef } from 'react';

const FormLogin = (props) => {
    let {loginData} = props;

    const usernameRef = useRef();
    const passwordRef = useRef();

    const loginForm = (e) => {
        e.preventDefault()
        const user = {username: usernameRef.current.value, password:passwordRef.current.value}
        loginData(user);
        usernameRef.current.value = "";
        passwordRef.current.value = "";
    }

    return (
        <form onSubmit={loginForm}>
            <div>
            <label htmlFor="username">Pseudo:</label>
            <input type="text" id='username' ref={usernameRef} />

            </div>
            <div>
                <label htmlFor="password">Mot de passe:</label>
                <input type="password" id="password" ref={passwordRef} />
            </div>
            <button type='submit'>Connexion</button>
        </form>
    );
}

export default FormLogin;
